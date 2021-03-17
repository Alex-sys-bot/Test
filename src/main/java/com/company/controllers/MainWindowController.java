package com.company.controllers;

import com.company.dao.Dao;
import com.company.model.Product;
import com.company.service.ProductService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class MainWindowController {

    private final SessionFactory factory;

    public MainWindowController(){
        factory = new Configuration().configure().buildSessionFactory();
    }

    @FXML
    private BorderPane borderPain;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TilePane tilePane;

    @FXML
    private TextField txtSearch;

    ObservableList<Product> products = FXCollections.observableArrayList();

    public static String role;


    @FXML
    public void initialize() throws IOException {
        initData();
        rubberWindow();
        generatedTiles(products);
        search();
        fullInfo();
    }



    private void fullInfo() throws IOException {
        FXMLLoader loader = FXMLLoader.load(getClass().getResource("/view/fullInfo.fxml"));
        AnchorPane anchorPane;
        anchorPane = loader.load();
        FullInfoController fullInfoController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
    }

    private void generatedTiles(ObservableList<Product> products) throws IOException {
        tilePane.getChildren().clear();

        AnchorPane anchorPane;
        tilePane.setAlignment(Pos.TOP_LEFT);
        tilePane.setVgap(25);
        tilePane.setHgap(25);

        for (Product product: products) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/tile.fxml"));
            anchorPane = loader.load();
            TileController tileController = loader.getController();

            tileController.setData(product);
            tilePane.getChildren().add(anchorPane);
        }
    }

    private void initData(){
        Dao<Product, Integer> productDao = new ProductService(factory);
        products.addAll(productDao.returnAll());
    }

    private void rubberWindow(){
        scrollPane.widthProperty().addListener((obj, oldValue, newValue) -> {
            tilePane.setPrefWidth(newValue.doubleValue());
        });
    }

    private void search(){
        txtSearch.setOnKeyReleased(event -> {
            ObservableList<Product> list = FXCollections.observableArrayList();

            for (Product product: products) {
                if (product.getName().toLowerCase().contains(txtSearch.getText().toLowerCase())){
                    list.add(product);
                }
            }
            try {
                generatedTiles(list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

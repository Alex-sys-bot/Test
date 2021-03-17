package com.company.controllers;

import com.company.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TileController {



    @FXML
    private ImageView imageCourse;

    @FXML
    private Label lblName;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblActive;



    private MyListener myListener;

    private Product product;

    public void click(MouseEvent event) {
        myListener.mouseClicked(product);
    }



    public void setData(Product product,MyListener myListener){
        this.myListener = myListener;
        this.product = product;
        lblName.setText(product.getName());
        imageCourse.setImage(new Image(product.getImagePath()));
    }

}

package com.company.controllers;

import com.company.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TileController {



    @FXML
    private ImageView imageCourse;

    @FXML
    private Label lblName;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblActive;


    public void setData(Product product){
        lblName.setText(product.getName());
        imageCourse.setImage(new Image(product.getImagePath()));
    }
}

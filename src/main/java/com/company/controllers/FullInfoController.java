package com.company.controllers;

import com.company.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FullInfoController {

    @FXML
    private Label lblName;


    public void setData(Product product){
        lblName.setText(product.getName());
    }


}

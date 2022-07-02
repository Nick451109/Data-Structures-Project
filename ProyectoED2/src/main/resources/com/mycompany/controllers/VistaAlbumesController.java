/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class VistaAlbumesController implements Initializable {

    @FXML
    private Label Album;
    @FXML
    private RadioButton rbLugar;
    @FXML
    private RadioButton rbPersona;
    @FXML
    private ComboBox<?> cbLugar;
    @FXML
    private ComboBox<?> cbPersonas;
    @FXML
    private TitledPane galleria;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author CAELOS JR 2018
 */
public class AlbumesController implements Initializable {

    @FXML
    private Label NombreAlbum;
    @FXML
    private Pane fotoImg;
    @FXML
    private Label fotoDesc;
    @FXML
    private Label fotoFecha;
    @FXML
    private Label fotoPersonas;
    @FXML
    private Label fotoLug;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fotoAnterior(MouseEvent event) {
    }

    @FXML
    private void sigFoto(MouseEvent event) {
    }

    @FXML
    private void agregarFoto(MouseEvent event) {
    }

    @FXML
    private void modificarInfo(MouseEvent event) {
    }

    @FXML
    private void regresarInicio(MouseEvent event) {
    }
    
}

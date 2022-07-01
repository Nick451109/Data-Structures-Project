/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controllers;

import Datos.Fotografias;
import Datos.Registro;
import TDAs.DLinkedList;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

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
    private Fotografias fActual;
    private DLinkedList<Fotografias> lFotografias;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lFotografias= Registro.getListaFotos();
        fActual = lFotografias.get(0);
        // TODO
    }    
    
    private void mostrarInformacio(Fotografias f){
        NombreAlbum.setText(f.getAlbum());
        fotoDesc.setText(f.getDescripcion());
        fotoFecha.setText(f.getLugar());
        fotoLug.setText(f.getLugar());
        
        
    }

    @FXML
    private void fotoAnterior(MouseEvent event) {
        fActual = lFotografias.getPriorD(fActual);
        
    }

    @FXML
    private void sigFoto(MouseEvent event) {
        fActual = lFotografias.getNextD(fActual);

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

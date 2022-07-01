/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controllers;

import Datos.Registro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author CAELOS JR 2018
 */
public class PaginaInicioController implements Initializable {

    @FXML
    private ComboBox<?> listaAlbumes;
    @FXML
    private ComboBox<?> buscarPor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void ingresarAlbum(MouseEvent event) {
        System.out.println("entra-------------------");
        Registro.cargaListaFotos();
        System.out.println("Sale--------------------");
        System.out.println(Registro.getListaFotos().toString());
    }

    @FXML
    private void crearAlbum(MouseEvent event) {
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controllers;

import Datos.Registro;
import com.mycompany.proyectoed2.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author CAELOS JR 2018
 */
public class CrearAlbumController implements Initializable {

    @FXML
    private TextField nombreAlbum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("________________________________________________");
        System.out.println(Registro.getListaFotos());
        System.out.println("_______________________________________________");
        // TODO
    }    

    @FXML
    private void crearAlbum(MouseEvent event) throws IOException {
        String nombreA = nombreAlbum.getText().trim();
        Registro.crearAlbum(nombreA);
        System.out.println(Registro.getListaAlbumes());
        App.setRoot("PaginaInicio");
    }

    @FXML
    private void paginaAnterior(MouseEvent event) throws IOException {
        App.setRoot("PaginaInicio");
    }
    
}

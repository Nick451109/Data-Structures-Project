/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controllers;

import Datos.Registro;
import TDAs.ArrayList;
import com.mycompany.proyectoed2.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CAELOS JR 2018
 */
public class PaginaInicioController implements Initializable {

    @FXML
    private ComboBox<String> listaAlbumes;
    @FXML
    private ComboBox<?> buscarPor;
    
    PaginaInicioController inicioCont;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Registro unico = new Registro();
        try {
            ArrayList<String> albumes = Registro.getListaAlbumes();
            for (int i = 0; i < albumes.size(); i++) {
                System.out.println("entramos");
                System.out.println(albumes.get(i));
                listaAlbumes.getItems().add(albumes.get(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void ingresarAlbum(MouseEvent event) throws IOException {
          String opcion = listaAlbumes.getValue();
          if (opcion == null){
              Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Comando invalido");
                alert.setContentText("No se ha seleccionado Album");
                alert.showAndWait();
                return;                            
          }
          Stage verAlb = new Stage();
          FXMLLoader loader = new FXMLLoader();
          AnchorPane root = (AnchorPane)loader.load(getClass().getResource("Albumes.fxml").openStream());
          AlbumesController AlbumesCInst = (AlbumesController)loader.getController();
    }

    @FXML
    private void crearAlbum(MouseEvent event) throws IOException {
        App.setRoot("CrearAlbum");
    }

}

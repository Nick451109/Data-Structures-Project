/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controllers;

import Datos.Fotografias;
import Datos.Registro;
import TDAs.DLinkedList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author CAELOS JR 2018
 */
public class VistaFotosController implements Initializable {
    //VistaAlbumesController vistAlb;
    private Fotografias fotoAct;
    private DLinkedList<Fotografias> lFotografiasActual;
    @FXML
    private Label nameAlb;
    @FXML
    private Pane imgPane;
    @FXML
    private Label decripLbl;
    @FXML
    private Label decripLgr;
    @FXML
    private Label descripPers;
    @FXML
    private Label descripFech;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lFotografiasActual = Registro.getListaFotosActual();
        fotoAct = Registro.getFoto();
        nameAlb.setText(fotoAct.getAlbum());
        decripLbl.setText(fotoAct.getDescripcion());
        decripLgr.setText(fotoAct.getLugar());
        descripPers.setText(fotoAct.getPersonas().toString());
        descripFech.setText(fotoAct.getFecha().toString());
        final Image image = new Image("file:./src/main/resources/img/" + fotoAct.getiD() + ".jpg", 150, 0, true, false);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        imgPane.getChildren().add(imageView);
        
        // TODO
    }    
    
    //public void recibeParametros(VistaAlbumesController vistAlb2,Fotografias f,DLinkedList<Fotografias> listaFilt){
        //System.out.println("hola");
        //vistAlb = vistAlb2;
        //lFotografiasActual = listaFilt;
    //}

    @FXML
    private void prevFoto(MouseEvent event) {
    }

    @FXML
    private void sigFoto(MouseEvent event) {
    }

    @FXML
    private void modFoto(MouseEvent event) {
    }

    @FXML
    private void elimFoto(MouseEvent event) {
    }

    @FXML
    private void RegresarVentana(MouseEvent event) {
    }
}

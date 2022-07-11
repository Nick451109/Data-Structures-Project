/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controllers;

import Datos.Fotografias;
import Datos.Registro;
import TDAs.DLinkedList;
import com.mycompany.proyectoed2.App;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class VistaFotosController implements Initializable{

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
    @FXML
    private Button btnEliminar;

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
        Fotografias nueva = lFotografiasActual.getPriorD(fotoAct);
        fotoAct = nueva;
        Registro.setFoto(fotoAct);
        MostrarFoto(fotoAct);
    }

    @FXML
    private void sigFoto(MouseEvent event) {
        Fotografias nueva = lFotografiasActual.getNextD(fotoAct);
        fotoAct = nueva;
        Registro.setFoto(fotoAct);
        MostrarFoto(fotoAct);

    }

    @FXML
    private void modFoto(MouseEvent event) throws IOException {
        Registro.setFoto(fotoAct);
        App.setRoot("VistaModificar");
    }

    @FXML
    private void elimFoto(MouseEvent event) throws IOException {
        DLinkedList<Fotografias> l1 = Registro.getListaFotos();
        //obtener la foto actual
        //obtener su ruta
        String ruta = "src/main/resources/img/" + fotoAct.getiD() + ".jpg";
        Path rutaconv = Paths.get(ruta);
        //aplicar el metodo de eliminar el elemento de esa ruta
        Files.delete(rutaconv);
        fotoAct = Registro.getFoto(); //foto actual
        int indice = l1.find(fotoAct);
        l1.remove(indice);
        Registro.setListaFotos(l1);
        /*Fotografias.clearFile(); 
        
        for (int i = 0; i < l1.size(); i++) {
            Fotografias nueva = l1.get(i);
            Fotografias.saveFile("Fotos.txt", nueva);
        }*/
        
         //hacer que cuando se elimine, regrese a la vista principal
         App.setRoot("vistaAlbumes");
         
         
    }

    @FXML
    private void RegresarVentana(MouseEvent event) throws IOException {
        App.setRoot("VistaAlbumes");
    }

    public void MostrarFoto(Fotografias f) {
        imgPane.getChildren().clear();
        nameAlb.setText(fotoAct.getAlbum());
        decripLbl.setText(fotoAct.getDescripcion());
        decripLgr.setText(fotoAct.getLugar());
        descripPers.setText(fotoAct.getPersonas().toString());
        descripFech.setText(fotoAct.getFecha().toString());
        final Image image = new Image("file:./src/main/resources/img/" + fotoAct.getiD() + ".jpg", 200, 200, true, false);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        imgPane.getChildren().add(imageView);
    }


}

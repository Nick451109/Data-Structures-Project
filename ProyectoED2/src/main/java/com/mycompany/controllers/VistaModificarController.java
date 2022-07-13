/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controllers;

import Datos.Fotografias;
import Datos.Registro;
import TDAs.ArrayList;
import TDAs.DLinkedList;
import com.mycompany.proyectoed2.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author CAELOS JR 2018
 */
public class VistaModificarController implements Initializable { //agregar la laerta de que los nombres de las personas deben estar separados por comas

    //FXML
    //private Label decripLbl;
    //@FXML
    //private Label decripLgr;
    @FXML
    private Label descripFech;
    //@FXML
    //private Label descripAlb;
    @FXML
    private TextField personasCambio;
    private Fotografias fotoAct;
    @FXML
    private Pane paneImg;
    @FXML
    private TextField LblLugar;
    @FXML
    private ComboBox<String> ListaAlb;
    @FXML
    private TextField LblDescripcion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> albumes = Registro.getListaAlbumes();
        for (int i = 0; i < albumes.size(); i++) {
                System.out.println("entramos");
                System.out.println(albumes.get(i));
                ListaAlb.getItems().add(albumes.get(i));
            }
        fotoAct = Registro.getFoto();
        paneImg.getChildren().clear();
        ListaAlb.setValue(fotoAct.getAlbum()); // lista de albumes
        //descripAlb.setText(fotoAct.getAlbum());
        //decripLbl.setText(fotoAct.getDescripcion());
        LblDescripcion.setText(fotoAct.getDescripcion()); // la descripcion 
        //decripLgr.setText(fotoAct.getLugar());
        LblLugar.setText(fotoAct.getLugar());  //obten en el lugar 
        personasCambio.setText(fotoAct.getPersonas().toString()); //obtiene las personas
        descripFech.setText(fotoAct.getFecha().toString());
        final Image image = new Image("file:./src/main/resources/img/" + fotoAct.getiD() + ".jpg", 200, 200, true, false);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        paneImg.getChildren().add(imageView);
        System.out.println(ListaAlb.getValue()+"---------------------------");
    }    

    @FXML
    private void regresarVista(MouseEvent event) throws IOException {
        App.setRoot("VistaFotos");
    }

    @FXML
    private void guardarCambios(MouseEvent event) throws IOException {
        String[] nueva = personasCambio.getText().split(",");
        ArrayList<String> nuevaList = new ArrayList<>();
        for(String s: nueva){
            nuevaList.addLast(s);
        }
        fotoAct.setPersonas(nuevaList); // setea personas
        fotoAct.setDescripcion(LblDescripcion.getText()); //setea la descripcion 
        fotoAct.setLugar(LblLugar.getText()); // setea el lugar
        fotoAct.setAlbum(ListaAlb.getValue()); // setea el album 
        Registro.setFoto(fotoAct);
        DLinkedList<Fotografias> actual = Registro.getListaFotos();
        Integer pos = actual.find(fotoAct);
        actual.set(pos, fotoAct);
        Registro.setListaFotos(actual);
        App.setRoot("VistaFotos");
    }
    
}

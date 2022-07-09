/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controllers;

import Datos.Alerta;
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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author CAELOS JR 2018
 */
public class EliminarAlbumController implements Initializable {

    @FXML
    private ComboBox<String> comboAlb;
    private ArrayList<String> albs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        albs =Registro.getListaAlbumes();
        for(int i = 0; i < albs.size(); i++){
                comboAlb.getItems().add(albs.get(i));
        }
        
        // TODO
    }    

    @FXML
    private void EliminarAlb(MouseEvent event) throws IOException {
        String albumSeleccionado = comboAlb.getValue();
        DLinkedList<Fotografias> lFotografias = Registro.getListaFotos();
        if (albumSeleccionado ==null){
            Alerta.crearAlerta("Opcion Invalida", "No se ha seleccionado ningun album");
        }else {
            for( int i = lFotografias.size(); i >= 0; i-- ){
                Fotografias foto= lFotografias.get(i);
                if(albumSeleccionado.equals((foto.getAlbum()))){
                   lFotografias.remove(i); 
                }
            }
            Registro.setListaFotos(lFotografias);
        }    
        for(int i = 0; i < albs.size(); i++){
            if( albs.get(i).equals(comboAlb.getValue())){
                albs.remove(i);
            }
        }
        Registro.setListaAlbumes(albs);
        App.setRoot("VistaAlbumes");
    }

    @FXML
    private void Regresar(MouseEvent event) throws IOException {
        App.setRoot("VistaAlbumes");
    }
    
}

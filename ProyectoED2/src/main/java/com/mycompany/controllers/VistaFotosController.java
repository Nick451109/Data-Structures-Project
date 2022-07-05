/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controllers;

import Datos.Fotografias;
import TDAs.DLinkedList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author CAELOS JR 2018
 */
public class VistaFotosController implements Initializable {
    VistaAlbumesController vistAlb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void recibeParametros(VistaAlbumesController vistAlb,Fotografias f,DLinkedList<Fotografias> listaFilt){
        
    }
}

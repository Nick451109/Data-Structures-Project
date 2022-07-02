/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.controllers;

import Datos.Fotografias;
import TDAs.ArrayList;
import com.mycompany.util.Util;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author CAELOS JR 2018
 */
 
public class AgregarFotoController implements Initializable {
    
    int idImagen;
    
    @FXML
    private TextField lbldescp;
    @FXML
    private TextField lbllugar;
    @FXML
    private TextField lblpersonas;
    @FXML
    private TextField lblalbum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
        public static String getExtension(String filename) {
        String extension = "";

        int i = filename.lastIndexOf('.');
        if (i
                > 0) {
            extension = filename.substring(i + 1);
        }
        return extension;
    }

    @FXML
    private void seleccionarFoto(ActionEvent event) {
        
        int id = Util.nextID("Fotos.txt");
        idImagen = id;
        String descripcion = lbldescp.getText();
        String lugar = lbllugar.getText();
        String personasi = lblpersonas.getText();
        String[] personasi2 = personasi.split(",");
        ArrayList<String> personasF = new ArrayList<>();
        for(String s: personasi2){
            personasF.addLast(s);
        }
        LocalDate fecha = LocalDate.now();
        String album = lblalbum.getText();
        String comentarios = " ";
        int reacciones = 0;
        //String iD, String descripcion, String lugar, ArrayList<String> personas, LocalDate fecha, String album, String comentarios, Integer reaccion
        Fotografias f1 = new Fotografias(id, descripcion, lugar, personasF,fecha,album, comentarios,reacciones);
        f1.saveFile("Fotos.txt");
        
        FileChooser fil_chooser = new FileChooser();
        fil_chooser.setInitialDirectory(new File(System.getProperty("user.home") + "\\Pictures")); //ruta predeterminada
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("IMG files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("IMG files (*.png)", "*.png");
        FileChooser.ExtensionFilter extFilter3 = new FileChooser.ExtensionFilter("IMG files (*.png)", "*.jpeg");

        fil_chooser.getExtensionFilters().add(extFilter);
        fil_chooser.getExtensionFilters().add(extFilter2);
        fil_chooser.getExtensionFilters().add(extFilter3);
        File file = fil_chooser.showOpenDialog(null);
        String extension = AgregarFotoController.getExtension(file.getName());

        Path a = Paths.get("src/main/resources/img/" + this.idImagen + "." + extension ); //implementar metodo delete de Files

        Path de = Paths.get(file.toURI());

        CopyOption[] options = new CopyOption[]{
            StandardCopyOption.REPLACE_EXISTING,
            StandardCopyOption.COPY_ATTRIBUTES
        };
        try {

                    Files.copy(de, a, options);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }
    
}

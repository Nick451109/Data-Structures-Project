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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author CAELOS JR 2018
 */
public class AgregarFotoController implements Initializable {    //falta agregar el elemento a lista de imagenes y tambien hay que poner un que la foto slaga antes de mostrar la descripcion.

    int idImagen;

    @FXML
    private TextField lbldescp;
    @FXML
    private TextField lbllugar;
    @FXML
    private TextField lblpersonas;
    @FXML
    private TextField lblalbum;
    @FXML
    private ComboBox<String> AlbDisp;
    private DLinkedList<Fotografias> fotos;
    @FXML
    private TextField fecha2;
    @FXML
    private TextField fecha1;
    @FXML
    private TextField fecha3;
    @FXML
    private DatePicker datepck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Se inicializo la vista AgregarFotos\n");       
        fotos = Registro.getListaFotos();
        try {
            ArrayList<String> albumes = Registro.getListaAlbumes();
            for (int i = 0; i < albumes.size(); i++) {
                AlbDisp.getItems().add(albumes.get(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

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
    private void seleccionarFoto(ActionEvent event) throws IOException {
         System.out.println("Se selecciono Foto\n");
        int id = Util.nextID("Fotos.txt");
        idImagen = id;
        String descripcion = lbldescp.getText();
        String lugar = lbllugar.getText();
        String personasi = lblpersonas.getText();
        String[] personasi2 = personasi.split(",");
        ArrayList<String> personasF = new ArrayList<>();
        for (String s : personasi2) {
            personasF.addLast(s);
        }

        LocalDate fecha = datepck.getValue();
        
        String album = AlbDisp.getValue();// String album = lblalbum.getText();
        String comentarios = " ";
        int reacciones = 0;
        Fotografias f1 = new Fotografias(id, descripcion, lugar, personasF, fecha, album, comentarios, reacciones);


        FileChooser fil_chooser = new FileChooser();
        fil_chooser.setInitialDirectory(new File(System.getProperty("user.home") + "\\Pictures")); //ruta predeterminada
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("IMG files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("IMG files (*.png)", "*.png");
        FileChooser.ExtensionFilter extFilter3 = new FileChooser.ExtensionFilter("IMG files (*.png)", "*.jpeg");

        fil_chooser.getExtensionFilters().add(extFilter);
        fil_chooser.getExtensionFilters().add(extFilter2);
        fil_chooser.getExtensionFilters().add(extFilter3);
        File file = fil_chooser.showOpenDialog(null);
        if ( file != null) {
            fotos.addLast(f1);
            Registro.setListaFotos(fotos);
            Fotografias.saveFile("Fotos.txt", f1);
            String extension = AgregarFotoController.getExtension(file.getName());

            Path a = Paths.get("src/main/resources/img/" + this.idImagen + "." + extension); //implementar metodo delete de Files

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
            Alerta.crearAlerta("Informacion", "La foto se ha creado correctamente");
        } else {
            Alerta.crearAlerta("Error", "No se selecciono foto");
        }

        App.setRoot("vistaAlbumes");
    }

    @FXML
    private void VentanaAnt(MouseEvent event) throws IOException {
        App.setRoot("vistaAlbumes");
    }

}

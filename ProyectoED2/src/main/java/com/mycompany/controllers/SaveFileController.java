/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nick1
 */
public class SaveFileController implements Initializable {

    @FXML
    private Button btGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void guardarFile(ActionEvent event) {

        FileChooser fil_chooser = new FileChooser();
        fil_chooser.setInitialDirectory(new File(System.getProperty("user.home") + "\\Pictures")); //ruta predeterminada
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("IMG files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("IMG files (*.png)", "*.png");
        FileChooser.ExtensionFilter extFilter3 = new FileChooser.ExtensionFilter("IMG files (*.png)", "*.jpeg");

        fil_chooser.getExtensionFilters().add(extFilter);
        fil_chooser.getExtensionFilters().add(extFilter2);
        fil_chooser.getExtensionFilters().add(extFilter3);
        File file = fil_chooser.showOpenDialog(null);

        Path a = Paths.get("src/main/resources/img/" + file.getName() + ".jpeg"); //implementar metodo delete de Files

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

    }}

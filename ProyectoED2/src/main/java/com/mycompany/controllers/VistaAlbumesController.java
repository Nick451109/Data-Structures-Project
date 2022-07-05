/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import Datos.Fotografias;
import Datos.Registro;
import TDAs.ArrayList;
import TDAs.DLinkedList;
import com.mycompany.proyectoed2.App;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class VistaAlbumesController implements Initializable {

    @FXML
    private FlowPane galleria;
    private Fotografias fActual;
    private DLinkedList<Fotografias> lFotografiasActual;
    private DLinkedList<Fotografias> lFotografiasOficial;
    @FXML
    private Label Album;
    @FXML
    private ComboBox<String> cbAlbum;
    @FXML
    private TextField txtBusqueda;
    @FXML
    private RadioButton rbLugar;
    @FXML
    private RadioButton rbPersonas;
    @FXML
    private RadioButton rbLugarPersonas;
    @FXML
    private RadioButton rbDescripcion;
    @FXML
    private RadioButton rbReacciones;
    @FXML
    private VBox vbOpciones;
    @FXML
    private ToggleGroup tgOpcion;
    VistaAlbumesController vistAlbCont;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vistAlbCont = this;
        lFotografiasOficial = Registro.getListaFotos();
        galleria.setPadding(new Insets(15, 15, 15, 15));
        galleria.setVgap(30);
        galleria.setHgap(20);
    }

    private void llenarCBAlbum() {
        try {
            cbAlbum.getItems().clear();
            ArrayList<String> albumes = Registro.getListaAlbumes();
            cbAlbum.getItems().add("Todos");
            cbAlbum.getItems().add("Ninguno");

            for (int i = 0; i < albumes.size(); i++) {
                System.out.println("entramos");
                System.out.println(albumes.get(i));
                cbAlbum.getItems().add(albumes.get(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private Pane crearFotoView(Fotografias foto) {

        Pane pane = new Pane();
        final Image image = new Image("file:./src/main/resources/img/" + foto.getiD() + ".jpg", 150, 0, true, false);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        pane.getChildren().add(imageView);
        imageView.setOnMouseClicked(event -> {
            try {
                Stage verAlb = new Stage();
                FXMLLoader loader = new FXMLLoader();
                AnchorPane root = (AnchorPane)loader.load(getClass().getResource("file:./src/main/com/mycompany/proyectoed2/VistaFotos.fxml").openStream());
                VistaFotosController FotosCInst = (VistaFotosController) loader.getController(); //aqui va el abumes controller
                FotosCInst.recibeParametros(vistAlbCont, foto, lFotografiasActual);
                Scene scene = new Scene(root);
                verAlb.setScene(scene);
                verAlb.alwaysOnTopProperty();
                verAlb.initModality(Modality.APPLICATION_MODAL);
                verAlb.show();
                //Se inserta lo que va a pasar cuando a cada imagen se le haga clic 
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        VBox vbox = new VBox();
        vbox.getChildren().add(pane);
        Label llugar = new Label();
        llugar.setText(foto.getLugar());
        vbox.getChildren().add(llugar);

        Label lalbum = new Label();
        lalbum.setText(foto.getAlbum());
        vbox.getChildren().add(lalbum);

        Label lpersonas = new Label();
        lpersonas.setText(foto.getPersonas().toString());
        vbox.getChildren().add(lpersonas);

        return vbox;
    }

    private void mostrarFotos(DLinkedList<Fotografias> lFotos) {
        lFotografiasActual = lFotos;
        for (int i = 0; i < lFotos.size(); i++) {
            Fotografias foto = lFotos.get(i);
            Pane footView = crearFotoView(foto);
            galleria.getChildren().add(footView);
        }
    }

    @FXML
    private void mostrarAlbum(MouseEvent event) {
        //  galleria.getChildren().clear();

        rbLugar.setSelected(false);
        rbPersonas.setSelected(false);
        rbLugarPersonas.setSelected(false);
        rbDescripcion.setSelected(false);
        rbReacciones.setSelected(false);
        txtBusqueda.setDisable(true);
        llenarCBAlbum();
        vbOpciones.setDisable(false);
        /*String opcion = cbAlbum.getValue();
        System.out.print(opcion);
        
        if(opcion == "Todos"){
            mostrarFotos(lFotografiasOficial);
        }else if (opcion=="Ninguno"){
            galleria.getChildren().clear();
        }*/
    }

    @FXML
    private void buscar(MouseEvent event) {
        galleria.getChildren().clear();
        String tbusqueda = txtBusqueda.getText();
        if (!(rbLugar.isSelected() || rbPersonas.isSelected() || rbLugarPersonas.isSelected() || rbDescripcion.isSelected() || rbReacciones.isSelected())) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Seleccione un tipo de Busqueda");
            alert.show();
        } else if (tbusqueda.equals("")) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("No se ha ingresado Busqueda");
            alert.show();
        }

    }

    @FXML
    private void habilitarBusqueda(MouseEvent event) {
        txtBusqueda.setDisable(false);

    }

    @FXML
    private void seleccionarAlbum(MouseEvent event) {
        //Actualizar nuevamente la lista oficial :)
        galleria.getChildren().clear();
        String opcion = cbAlbum.getValue();
        System.out.print(opcion);
        if (opcion == "Todos") {
            mostrarFotos(lFotografiasOficial);
        } else if (opcion == "Ninguno") {
            galleria.getChildren().clear();
        }
    }

    @FXML
    private void AnadirFotos(MouseEvent event) throws IOException {
        App.setRoot("AgregarFoto");
    }

    @FXML
    private void AnadirAlbum(MouseEvent event) throws IOException {
        App.setRoot("CrearAlbum");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import Datos.Alerta;
import Datos.Filtros;
import Datos.Fotografias;
import Datos.Registro;
import TDAs.ArrayList;
import TDAs.DLinkedList;
import com.mycompany.proyectoed2.App;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Stack;
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
    private DLinkedList<Fotografias> lFotografiasActual; //linkedlist con fotos pertenecientes a algun album especifico
    private DLinkedList<Fotografias> lFotografiasOficial; //linkedlist con todas las fotos
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
    @FXML
    private TextField txtPersonas;
    @FXML
    private TextField txtLugar;
    @FXML
    private Label lblPersonas;
    @FXML
    private Label lblLugar;

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
        
        //metodo para mostrar fotos habiendo seleccionado un album e iterado una foto de ese album

        Pane pane = new Pane(); //se crea el pane con la imagen
        final Image image = new Image("file:./src/main/resources/img/" + foto.getiD() + ".jpg", 150, 0, true, false); 
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        pane.getChildren().add(imageView);
        imageView.setOnMouseClicked(event -> { //cuando se clickea se pasa a la vistafotos
            try {
                Registro.setListaFotosActual(lFotografiasActual);
                Registro.setFoto(foto);
                App.setRoot("VistaFotos");
                //Stage verAlb = new Stage();
                //FXMLLoader loader = new FXMLLoader();
                //AnchorPane root = (AnchorPane)loader.load(App.class.getResource("VistaFotos.fxml"));
                //VistaFotosController FotosCInst = (VistaFotosController)loader.getController(); //aqui va el abumes controller
                //System.out.println(foto);
                //System.out.println(lFotografiasActual);
                //System.out.println(vistAlbCont);
                //System.out.println(FotosCInst);
                //FotosCInst.recibeParametros(vistAlbCont, foto, lFotografiasActual);
                //Scene scene = new Scene(root);
                //verAlb.setScene(scene);
                //verAlb.alwaysOnTopProperty();
                //verAlb.initModality(Modality.APPLICATION_MODAL);
                //verAlb.show();
                //Se inserta lo que va a pasar cuando a cada imagen se le haga clic 
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        
        //muestra descripcion, lugar y personas debajo de la foto 
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
        
        Label lDescripcion = new Label();
        lDescripcion.setText(foto.getDescripcion().toString());
        vbox.getChildren().add(lDescripcion);
        return vbox;
    }

    private void mostrarFotos(DLinkedList<Fotografias> lFotos) { //recibe una linkedlist con fotos pertenecientes a algun album especifico EJ: Centro
      //  lFotografiasActual = lFotos;
        if(lFotos.isEmpty()){
            galleria.getChildren().clear();
        }else {
            for (int i = 0; i < lFotos.size(); i++) {
            Fotografias foto = lFotos.get(i);
            
            //mostrar fotos en el pane
            Pane footView = crearFotoView(foto);
            galleria.getChildren().add(footView);
            }
        }
    }



    @FXML
    private void buscar(MouseEvent event) throws Exception {
        galleria.getChildren().clear();
        String tbusqueda = txtBusqueda.getText();
        DLinkedList<Fotografias> lFiltrada = new DLinkedList<>();
        if (!(rbLugar.isSelected() || rbPersonas.isSelected() || rbLugarPersonas.isSelected() || rbDescripcion.isSelected() || rbReacciones.isSelected())) {
            Alerta.crearAlerta("Comando Invalido", "Seleccione un tipo de Busqueda");
        }else if ((tbusqueda.equals(""))||(txtLugar.equals("")||txtPersonas.equals(""))) {
            Alerta.crearAlerta("Comando Invalido", "No se ha ingresado Busqueda");
        }else if (  cbAlbum.getValue() == null || cbAlbum.getValue()== "Ninguno"){
            Alerta.crearAlerta("Opcion Invalida", "No se ha seleccionado ningun album");
        }else {
            if(rbLugar.isSelected()){
                lFiltrada = filtrarLugar(tbusqueda);
                lFotografiasActual=lFiltrada;
                mostrarFotos(lFotografiasActual);
            }
            else if(rbPersonas.isSelected()){
                lFiltrada= filtrarPersonas(tbusqueda);
                lFotografiasActual=lFiltrada;
                mostrarFotos(lFotografiasActual); 
            }else if(rbLugarPersonas.isSelected()){
                DLinkedList<Fotografias> lLugares = new DLinkedList<>();
                lLugares= filtrarLugar(txtLugar.getText());
                DLinkedList<Fotografias> lPersonas  = new DLinkedList<>(); 
                lPersonas = filtrarPersonas(txtPersonas.getText());
                
                for(int i=0;i<lLugares.size();i++){
                    Fotografias foto = lLugares.get(i);
                    if(!(lPersonas.find(foto)==null)){
                        lFiltrada.addLast(foto);
                    }
                }lFotografiasActual=lFiltrada;
                mostrarFotos(lFotografiasActual);

            }else if(rbDescripcion.isSelected()){
                for(int i=0; i<lFotografiasActual.size();i++){
                    Fotografias foto= lFotografiasActual.get(i);
                    String descripcion=foto.getDescripcion();
                    if(descripcion.contains(tbusqueda)){
                        lFiltrada.addLast(foto);
                    }
                    
                }System.out.print(lFotografiasActual);
                mostrarFotos(lFiltrada); 
            }                
        }      
    }
    public DLinkedList<Fotografias> filtrarLugar(String tbusqueda){
        String lugar = tbusqueda;
        Fotografias f = new Fotografias(lugar);
        DLinkedList<Fotografias> lFiltrada =  Filtros.findAll(lFotografiasActual,(new Comparator<Fotografias>(){
            public int compare(Fotografias o1, Fotografias  o2) {
                if( (o1.getLugar()).toUpperCase().equals((o2.getLugar()).toUpperCase())){
                    return 0;
                }else{
                   return 1;
                }
            }} ),f);
        return lFiltrada;
                
    }
    public DLinkedList<Fotografias> filtrarPersonas(String tbusqueda ){
        String[] lBusqueda = tbusqueda.split(",");
        Stack<String> pBusqueda = new Stack<>();
        for(String s: lBusqueda){
                    pBusqueda.push(s);
                }int cantB= pBusqueda.size();
                Stack<Fotografias> pPersonas = new Stack<>();
                while (!pBusqueda.isEmpty()){
                    for(int i=0 ; i<lFotografiasActual.size();i++){
                        Fotografias f =  lFotografiasActual.get(i); 
                        ArrayList<String> lpersonas=f.getPersonas();
                        for(int j=0;j<lpersonas.size();j++){
                            String persona = lpersonas.get(j);
                            if(persona.toUpperCase().replace(" ","").equals(pBusqueda.peek().toUpperCase().replace(" ",""))){
                                pPersonas.push(f);
                                j=lpersonas.size();
                            }
                        }
                    }pBusqueda.pop();   
                }System.out.print("PILA DE PERSONAS" + pBusqueda+ pBusqueda.size());

                Map<Fotografias, Integer> mapFt = new LinkedHashMap<>();
                while(!pPersonas.isEmpty()){
                    if(mapFt.containsKey(pPersonas.peek())){
                        mapFt.put(pPersonas.peek(),mapFt.get(pPersonas.peek())+1);
                        pPersonas.pop();
                    }else{
                        mapFt.put(pPersonas.peek(),1);
                        pPersonas.pop();
                    }
                }Set<Fotografias> keySet = mapFt.keySet();
                Iterator<Fotografias> it2 = keySet.iterator();
                DLinkedList<Fotografias> lFiltrada= new DLinkedList<>();
                while(it2.hasNext()){
                    Fotografias foto = it2.next();
                    Integer cantF= mapFt.get(foto);
                    if(cantF==cantB){
                        lFiltrada.addLast(foto);
                    }
                }return lFiltrada;
                     
        
    }

    @FXML
    private void habilitarBusqueda(MouseEvent event) {
        txtBusqueda.setDisable(false);
        if(rbPersonas.isSelected()){
            Alerta.crearAlerta("Informacion", "Separar las personas por comas");  
        }else if(rbLugarPersonas.isSelected()){
            txtPersonas.setVisible(true);
            txtLugar.setVisible(true);
            lblPersonas.setVisible(true);
            lblLugar.setVisible(true);
            txtBusqueda.setVisible(false);
            Alerta.crearAlerta("Informacion", "Separar las personas por comas");

        }else if(!rbLugarPersonas.isSelected()){
            txtPersonas.setVisible(false);
            txtLugar.setVisible(false);
            lblPersonas.setVisible(false);
            lblLugar.setVisible(false);
            txtBusqueda.setVisible(true);
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



    @FXML//Selecciona el album a mostrar y llena el combo box
    private void SeleccionarAlbum(MouseEvent event) {
                //  galleria.getChildren().clear();
        rbLugar.setSelected(false);
        rbPersonas.setSelected(false);
        rbLugarPersonas.setSelected(false);
        rbDescripcion.setSelected(false);
        rbReacciones.setSelected(false);
        txtBusqueda.setDisable(true);
        llenarCBAlbum();
        vbOpciones.setDisable(false);
        txtBusqueda.clear();
        txtPersonas.setVisible(false);
        txtLugar.setVisible(false);
        lblPersonas.setVisible(false);
        lblLugar.setVisible(false);
        txtBusqueda.setVisible(true);

    }

    @FXML //Mustra el album seleccionado en el cbAlbum
    private void MostrarAlbum(MouseEvent event) {
        txtBusqueda.clear();
        txtPersonas.setVisible(false);
        txtLugar.setVisible(false);
        lblPersonas.setVisible(false);
        lblLugar.setVisible(false);
        txtBusqueda.setVisible(true);
        
        lFotografiasOficial = Registro.getListaFotos();//linkedlist de fotografias
        //Actualizar nuevamente la lista oficial :)
        galleria.getChildren().clear();
        String albumSeleccionado = cbAlbum.getValue();//album que elegi en el combobox
        System.out.print(albumSeleccionado);
        if (albumSeleccionado == "Todos") {
            mostrarFotos(lFotografiasOficial);
            lFotografiasActual = lFotografiasOficial;
        }else if (albumSeleccionado == "Ninguno") {
            galleria.getChildren().clear();
        }else if (albumSeleccionado ==null){
            Alerta.crearAlerta("Opcion Invalida", "No se ha seleccionado ningun album");
        }else {
            
            // cuando se selecciona un album creado
            DLinkedList <Fotografias> lfotos = new DLinkedList<>();
            for( int i = 0; i < lFotografiasOficial.size(); i++ ){
                Fotografias foto= lFotografiasOficial.get(i);
                if(albumSeleccionado.equals((foto.getAlbum()))){
                    //si el album que seleccione en el combobox es igual a el album de la foto iterada, se la añade
                   lfotos.addLast(foto); //linkedlist con las fotos que corresponden al album
                }
            }
            lFotografiasActual=lfotos;
            mostrarFotos(lFotografiasActual);
            
            
        }
    }

    @FXML
    private void eliminarAlbum(MouseEvent event) throws IOException {
        App.setRoot("EliminarAlbum");
    }




}

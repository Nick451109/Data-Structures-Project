package com.mycompany.proyectoed2;

import Datos.Fotografias;
import Datos.Registro;
import TDAs.DLinkedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //scene = new Scene(loadFXML("AgregarFoto"), 640, 480);
        stage.getIcons().add(new Image("icons/icono.jpg"));
        stage.setTitle("Gallery App");
        Registro.cargaListaFotos();
        System.out.println("CARGALISTAAAAAAAAAAAAAAAAAAAAAAAA");
        Registro.cargaListaALbum();
        System.out.println("cargaalbum");
        scene = new Scene(loadFXML("vistaAlbumes"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

     public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void stop() throws IOException{
        Fotografias.clearFile("Fotos.txt"); 
        
        DLinkedList<Fotografias> l1 = Registro.getListaFotos();
        
        for (int i = 0; i < l1.size(); i++) {
            Fotografias nueva = l1.get(i);
            Fotografias.saveFile("Fotos.txt", nueva);
        }
        
    System.out.println("Stage is closing");
    // Save file
}


}
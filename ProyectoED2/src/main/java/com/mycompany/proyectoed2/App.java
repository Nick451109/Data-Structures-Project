package com.mycompany.proyectoed2;

import Datos.Registro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //scene = new Scene(loadFXML("AgregarFoto"), 640, 480);
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
    public void stop(){
    System.out.println("Stage is closing");
    // Save file
}


}
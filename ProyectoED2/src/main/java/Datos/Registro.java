/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import TDAs.ArrayList;
import TDAs.DLinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author CAELOS JR 2018
 */
public class Registro {

    private static DLinkedList<Fotografias> listaFotos = new DLinkedList<>(); //lista de todas las fotos
    private static ArrayList<String> listaAlbumes = new ArrayList<>(); //lista de todos los albumes
    private static DLinkedList<Fotografias> listaFotosActual = new DLinkedList<>();
    private static Fotografias foto = new Fotografias(0,null,null,null,null,null,null,null); 

    public static void setFoto(Fotografias foto) {
        Registro.foto = foto;
    }

    public static Fotografias getFoto() {
        return foto;
    }

    public static void setListaFotosActual(DLinkedList<Fotografias> listaFotosActual) {
        Registro.listaFotosActual = listaFotosActual;
    }

    public static DLinkedList<Fotografias> getListaFotosActual() {
        return listaFotosActual;
    }

    public static void setListaFotos(DLinkedList<Fotografias> listaFotos) {
        Registro.listaFotos = listaFotos;
    }

    public static void setListaAlbumes(ArrayList<String> listaAlbumes) {
        listaAlbumes = listaAlbumes;
    }
    public static DLinkedList<Fotografias> getListaFotos() {
        return listaFotos;
    }

    public static ArrayList<String> getListaAlbumes() {
        return listaAlbumes;
    }

    public Registro() {
    }

    /*public Registro(DLinkedList<Fotografias> listaFotos, ArrayList<String> listaAlbumes) {
        this.listaFotos = listaFotos;
     */
    
    //metodo para cargar fotos a la variable listaFotos
    public static void cargaListaFotos() {
        System.out.println("Se esta cargando la lista Fotos\n");   
        DLinkedList<Fotografias> lFotos = new DLinkedList<>();
        try (BufferedReader bw = new BufferedReader(new FileReader("Fotos.txt"))) {
            String linea;
            while ((linea = bw.readLine()) != null) {
                String[] tokens = linea.split("\\|");
                String[] personas = tokens[3].split(",");
                ArrayList<String> personasAgg = new ArrayList<>();
                for (String s : personas) {
                    personasAgg.addLast(s);

                }
                System.out.println(personasAgg.toString());
                System.out.println(tokens[0]+tokens[1]+tokens[2]+personasAgg.toString()+tokens[4]+tokens[5]+tokens[6]+tokens[7]);
                Fotografias m = new Fotografias(
                        Integer.valueOf(tokens[0]), //id
                        tokens[1], //descrpcion
                        tokens[2],
                        personasAgg,
                        LocalDate.parse(tokens[4]),//revisar para que devuelva un arrayList
                        tokens[5],
                        tokens[6],
                        Integer.valueOf(tokens[7]));
                System.out.println(m.toString());
                lFotos.addLast(m);
                listaFotos=lFotos;

            }
        } catch (IOException e) {
            System.out.println("No se cargo la lista fotos\n");
            System.out.println(e.getClass());
        }
    }
    
    public static void cargaListaALbum() {
        System.out.println("Se esta cargando la lista album\n");
        try (BufferedReader bw = new BufferedReader(new FileReader("AlbumL.txt"))) {
            String linea;
            while ((linea = bw.readLine()) != null){ 
                listaAlbumes.addLast(linea.trim());
            }
        } catch (IOException e) {
            System.out.println("ERROR! No se pudo cargar la lista Album\n");
            System.out.println(e.getClass());
        }
    }
    
    public static void crearAlbum(String nombreA){
        System.out.println("Se creo un Album\n");        
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("AlbumL.txt", true))) {
            //id, descripcion, lugar, personas,fecha,album, comentarios,reacciones
            sb.append(nombreA).append(System.getProperty("line.separator"));
            ;
            bw.write(sb.toString());
            listaAlbumes.addLast(nombreA);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static Fotografias buscarPAlbum(String S){
        System.out.println("Se esta buscando un Album\n");        
        String albumComp = "";
        for( int i = 0; i < listaFotos.size(); i++ ){
            albumComp = listaFotos.get(i).getAlbum();
            if(S.toUpperCase().equals(albumComp.toUpperCase())){
                 return listaFotos.get(i);
            }
        }return null;        
    }
    
    public static Fotografias buscarSAlbum(Fotografias f){
        System.out.println("Se esta buscando un Album\n");        
        Integer posAct = listaFotos.find(f);
        for( int i = posAct; i < listaFotos.size() + posAct; i++ ){
            if(f.getAlbum().equals(listaFotos.get(i).getAlbum()))
                return listaFotos.get(i);
        }
        return null;
    }
    
    public static Fotografias buscarPAlbum(Fotografias f){
        System.out.println("Se esta buscando un Album\n");        
        Integer posAct = listaFotos.find(f);
        for( int i = posAct; i < listaFotos.size() + posAct; i++ ){
            if(f.getAlbum().equals(listaFotos.get(i).getAlbum()))
                return listaFotos.get(i);
        }
        return null;
    }

}

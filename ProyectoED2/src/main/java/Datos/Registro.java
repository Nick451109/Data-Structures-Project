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

    private static DLinkedList<Fotografias> listaFotos = new DLinkedList<>();
    private static ArrayList<String> listaAlbumes = new ArrayList<>();

    public static void setListaFotos(DLinkedList<Fotografias> listaFotos) {
        Registro.listaFotos = listaFotos;
    }

    public void setListaAlbumes(ArrayList<String> listaAlbumes) {
        Registro.listaAlbumes = listaAlbumes;
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

    public static void cargaListaFotos() {
        DLinkedList<Fotografias> lFotos = new DLinkedList<>();
        try (BufferedReader bw = new BufferedReader(new FileReader("Fotos.txt"))) {
            String linea;
            System.out.println("hola1--------------------------------------------------");
            while ((linea = bw.readLine()) != null) {
                String[] tokens = linea.split("\\|");
                String[] personas = tokens[3].split(",");
                System.out.println("hola2--------------------------------------------------");
                ArrayList<String> personasAgg = new ArrayList<>();
                for (String s : personas) {
                    System.out.println(s+"----------------------------------------------------");
                    personasAgg.addLast(s);
                    System.out.println("si se paso_______________________________________________");
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
                System.out.println("salimos del objeto");
                lFotos.addLast(m);
                System.out.println("se añade a la primera");
                listaFotos=lFotos;
                System.out.println("hola--------------------------------------------------");
            }
        } catch (IOException e) {
            System.out.println("hay error--------------------------***************");
            System.out.println(e.getClass());
        }
    }
    
    public static void cargaListaALbum() {
        try (BufferedReader bw = new BufferedReader(new FileReader("AlbumL.txt"))) {
            String linea;
            System.out.println("hola1--------------------------------------------------");
            while ((linea = bw.readLine()) != null){ 
                listaAlbumes.addLast(linea.trim());
                System.out.println("hola--------------------------------------------------");
            }
        } catch (IOException e) {
            System.out.println("hay error--------------------------***************");
            System.out.println(e.getClass());
        }
    }
    
    public static void crearAlbum(String nombreA){
        
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
        String albumComp = "";
        for( int i = 0; i < listaFotos.size(); i++ ){
            albumComp = listaFotos.get(i).getAlbum();
            if(S.toUpperCase().equals(albumComp.toUpperCase())){
                 return listaFotos.get(i);
            }
        }return null;        
    }
    
    public static Fotografias buscarSAlbum(Fotografias f){
        Integer posAct = listaFotos.find(f);
        for( int i = posAct; i < listaFotos.size() + posAct; i++ ){
            if(f.getAlbum().equals(listaFotos.get(i).getAlbum()))
                return listaFotos.get(i);
        }
        return null;
    }
    
    public static Fotografias buscarPAlbum(Fotografias f){
        Integer posAct = listaFotos.find(f);
        for( int i = posAct; i < listaFotos.size() + posAct; i++ ){
            if(f.getAlbum().equals(listaFotos.get(i).getAlbum()))
                return listaFotos.get(i);
        }
        return null;
    }

}

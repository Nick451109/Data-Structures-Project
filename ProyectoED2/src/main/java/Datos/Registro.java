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

    private DLinkedList<Fotografias> listaFotos;
    private ArrayList<String> listaAlbumes;

    public void setListaFotos(DLinkedList<Fotografias> listaFotos) {
        this.listaFotos = listaFotos;
    }

    public void setListaAlbumes(ArrayList<String> listaAlbumes) {
        this.listaAlbumes = listaAlbumes;
    }

    public DLinkedList<Fotografias> getListaFotos() {
        return listaFotos;
    }

    public ArrayList<String> getListaAlbumes() {
        return listaAlbumes;
    }

    public Registro(DLinkedList<Fotografias> listaFotos, ArrayList<String> listaAlbumes) {
        this.listaFotos = listaFotos;
        this.listaAlbumes = listaAlbumes;
    }

    /*public void cargaListaFotos() {
        java.util.ArrayList<Fotografias> mascotas = new java.util.ArrayList<>();
        try (BufferedReader bw = new BufferedReader(new FileReader(nomfile))) {
            String linea;
            while ((linea = bw.readLine()) != null) {
                String[] tokens = linea.split("\\|");
                String[] personas = tokens[3].split(",");
                ArrayList<String> personasAgg = new ArrayList<>();
                for (String s : personas) {
                    personasAgg.addLast(s);
                }
                Fotografias m = new Fotografias(
                        tokens[0], //id
                        tokens[1], //descrpcion
                        tokens[2],
                        personasAgg,
                        LocalDate.parse(tokens[4]),//revisar para que devuelva un arrayList
                        tokens[5],
                        tokens[6],
                        Integer.valueOf(tokens[7]));
                listaFotos.addLast(m);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/

}

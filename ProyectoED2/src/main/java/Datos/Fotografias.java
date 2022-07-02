/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import TDAs.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author CAELOS JR 2018
 */
public class Fotografias {

    private int iD;
    private String descripcion;
    private String lugar;
    private ArrayList<String> personas;
    private String album;
    private String comentarios;
    private Integer reacciones;
    private LocalDate fecha;

    public Fotografias(int iD, String descripcion, String lugar, ArrayList<String> personas, LocalDate fecha, String album, String comentarios, Integer reaccion) {
        this.iD = iD;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.personas = personas;
        this.album = album;
        this.comentarios = comentarios;
        this.reacciones = reaccion;
        this.fecha = fecha;

    }

    public int getiD() {
        return iD;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public ArrayList<String> getPersonas() {
        return personas;
    }

    public String getAlbum() {
        return album;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setPersonas(ArrayList<String> personas) {
        this.personas = personas;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    
    public boolean equals(Fotografias e) {
        if(this.getiD() == e.getiD()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Fotografias{" + "iD=" + iD + ", descripcion=" + descripcion + ", lugar=" + lugar + ", personas=" + personas.toString() + ", album=" + album + '}';
    }

    public String toSaver() {
        return (iD + "," + descripcion + "," + lugar + "," + personas.toString() + "," + album);
    }

    @SuppressWarnings("empty-statement")
    public void saveFile(String nomfile) {
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomfile, true))) {
            //id, descripcion, lugar, personas,fecha,album, comentarios,reacciones
            sb.append(this.iD).append("|");
            sb.append(this.descripcion).append("|");
            sb.append(this.lugar).append("|");
            sb.append(this.personas.toString()).append("|");
            sb.append(this.fecha).append("|");
            sb.append(this.album).append("|");
            sb.append(this.comentarios).append("|");
            sb.append(this.reacciones).append(System.getProperty("line.separator"));
            ;;

            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}

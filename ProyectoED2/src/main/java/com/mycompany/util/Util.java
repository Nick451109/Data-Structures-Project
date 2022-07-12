/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author Nick
 */
public class Util {
    
    private Util(){}
    
    
    public static int nextID(String nomfile)
    {
        int id = 0;
        try (BufferedReader bw = new BufferedReader(new FileReader(nomfile))) {
            String linea;
            while ((linea = bw.readLine()) != null) {
                String[] tokens = linea.split("\\|"); //[1,jvvuv,vuy]
                for (String s: tokens){
                    System.out.println(s);
                }
                id = Integer.parseInt(tokens[0]);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("INCREMENTADO");
        System.out.println(id+1);//1
        return id+1;        
    }
    
}
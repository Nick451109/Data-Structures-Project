/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import TDAs.DLinkedList;
import java.util.Comparator;

/**
 *
 * @author USUARIO
 */
public class Filtros {
        
    public static DLinkedList<Fotografias> findAll (DLinkedList<Fotografias> elements, Comparator cmp , Fotografias anotherElement){
        DLinkedList<Fotografias> results = new DLinkedList<>();
        for(int i=0; i<elements.size();i++){
            Fotografias element= elements.get(i);
            if(cmp.compare(element, anotherElement)==0){
                results.addLast(element);
            }
        }return results;
   }
    
    
    
}

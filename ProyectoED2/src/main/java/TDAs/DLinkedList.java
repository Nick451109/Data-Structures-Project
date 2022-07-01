/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAs;

import java.util.Iterator;

/**
 *
 * @author CAELOS JR 2018
 */
public class DLinkedList<E> implements List<E> {

    //private NodeList<E> first;
    private NodeListD<E> last;

    public DLinkedList() {
        this.last = null;
    }

    public NodeListD<E> getLast() {
        return last;
    }

    public void setLast(NodeListD<E> last) {
        this.last = last;
    }

    @Override
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        }
        NodeListD<E> nuevo = new NodeListD<>(e);
        if(this.isEmpty()){
            this.setLast(nuevo);
            return true;
        }else{
            NodeListD<E> antiguoLast = this.getLast();
            nuevo.setPrior(antiguoLast);
            nuevo.setNext(antiguoLast.getNext());
            this.setLast(nuevo);
            return true;
        }
    } //revisar

    @Override
    public boolean addLast(E e) {
        if (e == null) {
            return false;
        }
        NodeListD<E> nuevo = new NodeListD<>(e);
        if (this.isEmpty()) {
            this.setLast(nuevo);
        } else {
            nuevo.setNext(last.getNext());
            nuevo.setPrior(last);
            last.getNext().setPrior(nuevo);
            last.setNext(nuevo);
            this.setLast(nuevo);
            //this.getLast().setNext(nuevo);
        }
        //this.setLast(nuevo);

        return true;
    }

    @Override
    public E removeFirst() {  //revisar que sucede si se queda un solo elemento 
        if (this.isEmpty()) {
            System.out.println("LinkedList vacia");
            return null;
        }
        NodeListD<E> eliminado = last.getNext();
        last.setNext(eliminado.getNext());
        eliminado.getNext().setPrior(last);
        return eliminado.getContent();
    }

    @Override
    public E removeLast() { //revisar que sucede si se queda un solo elemento(creo que la respuesta es poner un if es 1,el valor last se lo deja en null 
        if (this.isEmpty()) {
            System.out.println("LinkedList vacia");
            return null;
        }
        NodeListD<E> eliminado = last;
        //NodeList<E> t;
        //for (t = this.getFirst(); t.getNext() == last; t = t.getNext()) {
        //}
        eliminado.getPrior().setNext(eliminado.getNext());
        eliminado.getNext().setPrior(eliminado.getPrior());
        this.last = eliminado.getPrior();
        return eliminado.getContent();
    }

    @Override
    public int size() {
        if(this.getLast().getNext() == null && this.getLast().getPrior() == null){
            return 1;
        }
        int cont = 0;
        NodeListD<E> t;
        for (t = this.getLast().getNext(); t != last; t = t.getNext()) {
            cont++;
        }
        cont++;
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return this.last == null;
    }

    @Override
    public void clear() {
        this.last = null;
    }

    @Override
    public void add(int index, E element) {
        int cont = 0;
        if (element == null) {
            System.out.println("No hay contenido");
        } else if (index > size() ||index < 0) {
            throw new IndexOutOfBoundsException("No existe el indice");
        } else if (index == 0){
                   NodeListD<E> nuevo = new NodeListD<>(element);
                   nuevo.setNext(last.getNext());
                   nuevo.setPrior(last);
                   last.getNext().setPrior(nuevo);
                   last.setNext(nuevo);
        } else {
            NodeListD<E> t;
            for (t = last.getNext(); cont < (index - 1) ; t = t.getNext()) {
                cont++;
            }
            System.out.println(t.getContent());
            NodeListD<E> nuevo = new NodeListD<>(element);
            nuevo.setNext(t.getNext());
            nuevo.setPrior(t);
            t.getNext().setPrior(nuevo);
            t.setNext(nuevo);
            System.out.println(nuevo.getContent());
            if(nuevo.getNext() == last.getNext()){ ///reviasr si esta comparacion es correcta
                this.last = nuevo;
            }
        }
    }

    @Override
    public E remove(int index) {
        int cont = 0;
        if (index >size() ||index < 0) {
            throw new IndexOutOfBoundsException("No existe el indice");
        }
        else if (index == 0){
                   NodeListD<E> aEliminar = last.getNext();
                   last.setNext(aEliminar.getNext());
                   aEliminar.getNext().setPrior(last);
                   return aEliminar.getContent();
        }
        else {
            NodeListD<E> t;
            for (t = last.getNext(); cont < (index-1) ; t = t.getNext()) {
                cont++;
                ;
            }
            NodeListD<E> retorno = t.getNext();
            t.setNext(retorno.getNext());
            retorno.getNext().setPrior(retorno.getPrior());
            if ( retorno.getNext() == last.getNext() ){
               this.last = t;
            }
            return retorno.getContent();
        }
    }

    @Override
    public E get(int index) {
        int cont = 0;
         if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("No existe el indice");
         }
         else {
            NodeListD<E> t;
            for (t = last.getNext();  cont < (index) ; t = t.getNext()) {
                cont++;
                ;
            }
            return t.getContent();
         }
    }

    @Override
    public E set(int index, E element) {
        if (element == null) {
            System.out.println("LinkedList vacia");
        } else if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("No existe el indice");
        } else {
            int cont = 0;
            NodeListD<E> t;
            for (t = last.getNext();  cont < (index) ; t = t.getNext()) {
                cont++;
            }
            t.setContent(element);
        }
        return element;
    }

    @Override
    public String toString() {
        String s = "";
        NodeListD<E> t;
        for (t = last.getNext();  t.getNext() != last.getNext(); t = t.getNext()) {
            s += t.getContent().toString() + " ";
        }
        return s;
    }
    public E getNextD(E e){
        NodeListD<E> nodoEncontrado = last; 
        while(!nodoEncontrado.getContent().equals(e)){
            nodoEncontrado=nodoEncontrado.getNext();
        }
        
        return (nodoEncontrado.getNext()).getContent();
    }
    
    public E getPriorD(E e){
        NodeListD<E> nodoEncontrado = last; 
        while(!nodoEncontrado.getContent().equals(e)){
            nodoEncontrado=nodoEncontrado.getPrior();
        }
        return (nodoEncontrado.getPrior()).getContent();
    }





}

//insertar un elemento en medio de la lista
                   //NodeListD<E> nuevo = new NodeListD<>(element);
                   //nuevo.setNext(last.getNext());
                   //nuevo.setPrior(last);
                   //last.getNext().setPrior(nuevo);
                   //last.setNext(nuevo);

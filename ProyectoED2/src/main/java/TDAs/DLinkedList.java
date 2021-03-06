/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAs;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author CAELOS JR 2018
 */
public class DLinkedList<E> implements List<E> {

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
        if (this.isEmpty()) {
            this.setLast(nuevo);
            nuevo.setNext(last);
            nuevo.setPrior(last);
            return true;
        } else {
            NodeListD<E> antiguoFirst = this.getLast().getNext();
            nuevo.setPrior(last);
            nuevo.setNext(this.getLast().getNext());
            this.getLast().getNext().setPrior(nuevo);
            last.setNext(nuevo);
            return true;
        }
    } //revisar

    @Override
    public boolean addLast(E e) {
        if (e == null) {
            System.out.println("entro 1 if");
            return false;
        }
        NodeListD<E> nuevo = new NodeListD<>(e);
        if (this.isEmpty()) {
            System.out.println("entro 2 if");
            this.setLast(nuevo);
            nuevo.setNext(last);
            nuevo.setPrior(last);
        } else {
            NodeListD<E> siguienteN = new NodeListD<>(e);
            System.out.println("entro 3 if");
            nuevo.setNext(last.getNext());
            nuevo.setPrior(last);
            siguienteN = last.getNext();
            siguienteN.setPrior(nuevo);
//last.getNext().setPrior(nuevo);
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
        if(this.size() == 1){
            this.last = null;
        }
        NodeListD<E> eliminado = last.getNext();
        last.setNext(eliminado.getNext());
        eliminado.getNext().setPrior(last);
        return eliminado.getContent();
    }

    @Override
    public E removeLast() { 
        if (this.isEmpty()) {
            System.out.println("LinkedList vacia");
            return null;
        }
        if(this.size() == 1){
            this.last = null;
        }
        NodeListD<E> eliminado = last;

        eliminado.getPrior().setNext(eliminado.getNext());
        eliminado.getNext().setPrior(eliminado.getPrior());
        this.last = eliminado.getPrior();
        return eliminado.getContent();
    }

    @Override
    public int size() {
        if(this.getLast() == null){
            return 0;
        }
        if (this.getLast().getNext() == last && this.getLast().getPrior() == last) {
            return 1;
        }
        int cont = 0;
        NodeListD<E> t = last.getNext();
        while(true){
            cont++;
            t = t.getNext();
            if (t == last.getNext())
                break;
        }
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
        } else if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("No existe el indice");
        } else if (index == 0) {
            NodeListD<E> nuevo = new NodeListD<>(element);
            nuevo.setNext(last.getNext());
            nuevo.setPrior(last);
            last.getNext().setPrior(nuevo);
            last.setNext(nuevo);
        } else {
            NodeListD<E> t;
            for (t = last.getNext(); cont < (index - 1); t = t.getNext()) {
                cont++;
            }
            System.out.println(t.getContent());
            NodeListD<E> nuevo = new NodeListD<>(element);
            nuevo.setNext(t.getNext());
            nuevo.setPrior(t);
            t.getNext().setPrior(nuevo);
            t.setNext(nuevo);
            System.out.println(nuevo.getContent());
            if (nuevo.getNext() == last.getNext()) { ///reviasr si esta comparacion es correcta
                this.last = nuevo;
            }
        }
    }

    @Override
    public E remove(int index) {
        int cont = 0;
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("No existe el indice");
        } else if (index == 0) {
            NodeListD<E> aEliminar = last.getNext();
            last.setNext(aEliminar.getNext());
            aEliminar.getNext().setPrior(last);
            return aEliminar.getContent();
        } else {
            NodeListD<E> t;
            for (t = last.getNext(); cont < (index - 1); t = t.getNext()) {
                cont++;
                ;
            }
            NodeListD<E> retorno = t.getNext();
            t.setNext(retorno.getNext());
            retorno.getNext().setPrior(retorno.getPrior());
            if (retorno.getNext() == last.getNext()) {
                this.last = t;
            }
            return retorno.getContent();
        }
    }

    @Override
    public E get(int index) {
        int cont = 0;
        if(this.size() == 0){
            throw new IndexOutOfBoundsException("No existe el indice");
        }else{
        if (index > size() ) {
            index = index % this.size();
        }if (index < 0){
               index = ((index%this.size())+this.size());
        }
            NodeListD<E> t;
            for (t = last.getNext(); cont < (index); t = t.getNext()) {
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
            for (t = last.getNext(); cont < (index); t = t.getNext()) {
                cont++;
            }
            t.setContent(element);
        }
        return element;
    }

    @Override
    public String toString() {
        String s = "";
        NodeListD<E> t = last.getNext();
        do {
            s += t.getContent().toString() + " ";
            t = t.getNext();
        }while(t.getNext() != last.getNext().getNext());
        //for (t = last.getNext(); t.getNext() != last.getNext(); t = t.getNext()) {
        //    s += t.getContent().toString() + " ";
        //}
        return s;
    }
    
    public Integer find(E e) {
        if (e == null) {
            System.out.println("entro 1 if");
            return null;
        }
        NodeListD<E> nuevo = new NodeListD<>(e);
        if (this.isEmpty()) {
            return null;
        }
        int cont = 0;
        NodeListD<E> t = last.getNext();
        while(true){
            if (t.getContent().equals(e))
                break;
            cont++;
            t = t.getNext();
            
            if (cont >= this.size())
                return null;
        }
        //for (t = this.getLast().getNext(); t != last; t = t.getNext()) {
        //    cont++;
        //}
        //cont++;
        return cont;
    }

    public E getNextD(E e) {
        NodeListD<E> nodoEncontrado = last;
        while (!nodoEncontrado.getContent().equals(e)) {
            nodoEncontrado = nodoEncontrado.getNext();
        }

        return (nodoEncontrado.getNext()).getContent();
    }

    public E getPriorD(E e) {
        NodeListD<E> nodoEncontrado = last;
        while (!nodoEncontrado.getContent().equals(e)) {
            nodoEncontrado = nodoEncontrado.getPrior();
        }
        return (nodoEncontrado.getPrior()).getContent();
    }








}
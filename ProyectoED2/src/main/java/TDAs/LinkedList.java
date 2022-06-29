/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAs;

/**
 *
 * @author CAELOS JR 2018
 */
public class LinkedList<E> implements List<E> {

    //private NodeList<E> first;
    private NodeListD<E> last;

    public LinkedList() {
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
            this.getLast().setNext(nuevo);
            nuevo.setNext(last.getNext());
            nuevo.setPrior(last);
        }
        this.setLast(nuevo);

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
            NodeList<E> t;
            for (t = this.getFirst(); cont < (index - 1) ; t = t.getNext()) {
                cont++;
            }
            System.out.println(t.getContent());
            NodeList<E> nuevo = new NodeList<>(element);
            nuevo.setNext(t.getNext());
            t.setNext(nuevo);
            System.out.println(nuevo.getContent());
            if(nuevo.getNext() == null){
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
                   NodeList<E> nuevo = first;
                   this.first = nuevo.getNext();
                   return nuevo.getContent();
        }
        else {
            NodeList<E> t;
            for (t = this.getFirst(); cont < (index-1) ; t = t.getNext()) {
                cont++;
                ;
            }
            NodeList<E> retorno = t.getNext();
            t.setNext(retorno.getNext());
            if ( retorno.getNext() == null ){
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
            NodeList<E> t;
            for (t = this.getFirst(); cont < (index) ; t = t.getNext()) {
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
            NodeList<E> t;
            for (t = this.getFirst(); cont < (index) ; t = t.getNext()) {
                cont++;
            }
            t.setContent(element);
        }
        return element;
    }

    @Override
    public String toString() {
        String s = "";
        NodeList<E> t;
        for (t = this.getFirst(); t != null; t = t.getNext()) {
            s += t.getContent() + " ";
        }
        return s;
    }

}

//insertar un elemento en medio de la lista
                   //NodeListD<E> nuevo = new NodeListD<>(element);
                   //nuevo.setNext(last.getNext());
                   //nuevo.setPrior(last);
                   //last.getNext().setPrior(nuevo);
                   //last.setNext(nuevo);

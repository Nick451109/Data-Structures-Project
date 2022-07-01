/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAs;
/**
 *
 * @author CAELOS JR 2018
 */
public class ArrayList<E> implements List<E>{

    private int capacity = 100;
    private E[] elements = null;
    private int effectiveSize = 0;

    public ArrayList() {
        this.elements = (E[]) (new Object[capacity]);
        this.effectiveSize = 0;
    }

    private boolean isFull() {
        return elements.length == effectiveSize;
    }

    private void addCapacity() {
        E[] tmp = (E[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            tmp[i] = elements[i];
        }
        elements = tmp;
        capacity = capacity * 2;
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public void clear() {
        effectiveSize = 0;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < effectiveSize; i++) {
            result += elements[i].toString() + " ";
        }
        return result;
    }

    @Override
    public boolean addFirst(E element) {
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            elements[effectiveSize++] = element;
            return true;
        } else if (capacity == effectiveSize) {
            addCapacity();
        }
        for (int i = effectiveSize - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
        }
        elements[0] = element;
        effectiveSize++;
        return true;
    }

    /* EN ESTE TALLER, USTED DEBE IMPLEMENTAR LOS SIGUIENTES MÉTODOS */
    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            elements[effectiveSize++] = element;
            return true;
        } else if (capacity == effectiveSize) {
            addCapacity();
        }
        elements[effectiveSize++] = element;
        return true;
    }

    @Override
    public E removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("No hay elementos a borrar");
            //System.out.println("No hay elementos a borrar");
            //return null;
        }
        E retorno = elements[0];
        for (int i = 0; i <= effectiveSize - 1; i++) { //creo que asi va 
            elements[i] = elements[i + 1];
        }
        effectiveSize--;
        return retorno;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            //throw new Exception("No hay elementos a borrar");
            System.out.println("No hay elementos a borrar");
            return null;
        }
        E retorno = elements[effectiveSize - 1];
        effectiveSize--;
        return retorno;
    }

    @Override
    public void add(int index, E element) throws Exception {
        if (isEmpty()) {
            throw new Exception("No existe la posicion");
            //System.out.println("No hay elementos a borrar");
            //return null;
        } else if (index >= effectiveSize || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Esta fuera del indice");
        } else if (capacity == effectiveSize) {
            addCapacity();
        }
        for (int i = effectiveSize - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        effectiveSize++;
    }

    @Override
    public E remove(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("no hay elementos a remover");
        } else if (index >= effectiveSize  || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Esta fuera del indice");
        }
        E retorno = elements[index];
        for (int i = index; i <= effectiveSize - 1; i++) { //creo que asi va 
            elements[i] = elements[i + 1];
        }
        effectiveSize--;
        return retorno;
    }
    

    @Override
    public E get(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("no hay elementos a encontrar");
        } else if (index >= effectiveSize  || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Esta fuera del indice");
        }
        return elements[index];
    }

    @Override
    public E set(int index, E element) throws Exception {
        if (isEmpty()) {
            throw new Exception("no hay elementos a encontrar");
        } else if (index >= effectiveSize || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Esta fuera del indice");
        }
        E retorno = elements[index];
        elements[index] = element;
        return retorno;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDAs;

/**
 *
 * @author CAELOS JR 2018
 */
class NodeListD<E> {
    private E content;
    private NodeListD<E> next;
    private NodeListD<E> prior;

    public NodeListD(E content){
        this.content = content;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public NodeListD<E> getNext() {
        return next;
    }

    public void setNext(NodeListD<E> next) {
        this.next = next;
    }
    
    public NodeListD<E> getPrior() {
        return prior;
    }

    public void setPrior(NodeListD<E> prior) {
        this.prior = prior;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LaGuaridadelDragon;

/**
 *
 * @author nn
 */
public class Nodo {
    private Tesoro tesoro;
    private Nodo izquierdo;
    private Nodo central;
    private Nodo derecho;

    public Nodo(Tesoro tesoro) {
        this.tesoro = tesoro;
        this.izquierdo = null;
        this.central = null;
        this.derecho = null;
    }

    public Tesoro verTesoro() {
        return tesoro;
    }

    public Nodo verNodoIzquierdo() {
        return izquierdo;
    }

    public Nodo verNodoCentral() {
        return central;
    }

    public Nodo verNodoDerecho() {
        return derecho;
    }

    public void modifNodoIzquierdo(Nodo nodo) {
        this.izquierdo = nodo;
    }

    public void modifNodoCentral(Nodo nodo) {
        this.central = nodo;
    }

    public void modifNodoDerecho(Nodo nodo) {
        this.derecho = nodo;
    }

    
}

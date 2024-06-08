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


public class ArbolTernario {
      private Nodo raiz;
      private int niveles;

    public ArbolTernario() {
        this.raiz = null;
    }
    public void inicializarArbol(int niveles) {
    this.raiz = construirArbolRecursivo(niveles, 1);
}

private Nodo construirArbolRecursivo(int niveles, int nivelActual) {
    if (nivelActual > niveles) {
        return null;
    }

   Nodo nodo = new Nodo(new Tesoro(0, ""));
    nodo.modifNodoIzquierdo(construirArbolRecursivo(niveles, nivelActual + 1));
    nodo.modifNodoCentral(construirArbolRecursivo(niveles, nivelActual + 1));
    nodo.modifNodoDerecho(construirArbolRecursivo(niveles, nivelActual + 1));
    return nodo;
}

    public void insertar(Tesoro tesoro) {
        raiz = insertarRecursivo(raiz, tesoro);
    }

   private Nodo insertarRecursivo(Nodo nodo, Tesoro tesoro) {
    if (nodo == null) {
        System.out.println("Insertando tesoro con valor: " + tesoro.verValor());
        return new Nodo(tesoro);
    }

    int valorNodo = nodo.verTesoro().verValor();
    int valorTesoro = tesoro.verValor();

    if (valorTesoro < valorNodo) {
        System.out.println("Insertando a la izquierda de " + valorNodo + " el tesoro con valor: " + valorTesoro);
        Nodo nodoIzquierdo = insertarRecursivo(nodo.verNodoIzquierdo(), tesoro);
        nodo.modifNodoIzquierdo(nodoIzquierdo);
    } else if (valorTesoro == valorNodo) {
        System.out.println("Insertando en el centro de " + valorNodo + " el tesoro con valor: " + valorTesoro);
        Nodo nodoCentral = insertarRecursivo(nodo.verNodoCentral(), tesoro);
        nodo.modifNodoCentral(nodoCentral);
    } else {
        System.out.println("Insertando a la derecha de " + valorNodo + " el tesoro con valor: " + valorTesoro);
        Nodo nodoDerecho = insertarRecursivo(nodo.verNodoDerecho(), tesoro);
        nodo.modifNodoDerecho(nodoDerecho);
    }

    return nodo;
}

    public Tesoro buscarTesoroMasValioso() {
        return buscarTesoroMasValiosoRecursivo(raiz, null);
    }

    private Tesoro buscarTesoroMasValiosoRecursivo(Nodo nodo, Tesoro tesoroMasValioso) {
        if (nodo == null) {
            return tesoroMasValioso;
        }

        if (tesoroMasValioso == null || nodo.verTesoro().verValor() > tesoroMasValioso.verValor()) {
            tesoroMasValioso = nodo.verTesoro();
        }

        tesoroMasValioso = buscarTesoroMasValiosoRecursivo(nodo.verNodoIzquierdo(), tesoroMasValioso);
        tesoroMasValioso = buscarTesoroMasValiosoRecursivo(nodo.verNodoCentral(), tesoroMasValioso);
        tesoroMasValioso = buscarTesoroMasValiosoRecursivo(nodo.verNodoDerecho(), tesoroMasValioso);

        return tesoroMasValioso;
    }


    public NivelTesoro TesoroMasValioso() {
    return buscarTesoroMasValiosoRecursivo(raiz, null, 0, 0);
}

public NivelTesoro buscarTesoroMasValiosoRecursivo(Nodo nodo, NivelTesoro tesoroNivelMasProfundo, int nivelActual, int nivelMasProfundo) {
    if (nodo == null) {
        return tesoroNivelMasProfundo;
    }

    if (nodo.verTesoro() != null && (tesoroNivelMasProfundo == null || nodo.verTesoro().verValor() > tesoroNivelMasProfundo.getTesoro().verValor())) {
        tesoroNivelMasProfundo = new NivelTesoro(nodo.verTesoro(), nivelActual);
    }

    if (nivelActual > nivelMasProfundo) {
        nivelMasProfundo = nivelActual;
    }

    NivelTesoro tesoroNivelIzquierdo = buscarTesoroMasValiosoRecursivo(nodo.verNodoIzquierdo(), tesoroNivelMasProfundo, nivelActual + 1, nivelMasProfundo);
    NivelTesoro tesoroNivelCentral = buscarTesoroMasValiosoRecursivo(nodo.verNodoCentral(), tesoroNivelMasProfundo, nivelActual + 1, nivelMasProfundo);
    NivelTesoro tesoroNivelDerecho = buscarTesoroMasValiosoRecursivo(nodo.verNodoDerecho(), tesoroNivelMasProfundo,nivelActual + 1, nivelMasProfundo);

    if (tesoroNivelIzquierdo != null && tesoroNivelIzquierdo.getNivel() > nivelMasProfundo) {
        return tesoroNivelIzquierdo;
    }
    if (tesoroNivelCentral != null && tesoroNivelCentral.getNivel() > nivelMasProfundo) {
        return tesoroNivelCentral;
    }
    if (tesoroNivelDerecho != null && tesoroNivelDerecho.getNivel() > nivelMasProfundo) {
        return tesoroNivelDerecho;
    }

    return tesoroNivelMasProfundo;
}
}

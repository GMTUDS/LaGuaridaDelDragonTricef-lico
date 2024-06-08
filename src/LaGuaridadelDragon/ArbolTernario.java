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

    public ArbolTernario() {
        this.raiz = null;
    }

    public void insertar(Tesoro tesoro) {
        raiz = insertarRecursivo(raiz, tesoro);
    }

    private Nodo insertarRecursivo(Nodo nodo, Tesoro tesoro) {
        if (nodo == null) {
            return new Nodo(tesoro);
        }

        int valorNodo = nodo.verTesoro().verValor();
        int valorTesoro = tesoro.verValor();

        if (valorTesoro < valorNodo) {
            nodo.modifNodoIzquierdo(insertarRecursivo(nodo.verNodoIzquierdo(), tesoro));
        } else if (valorTesoro == valorNodo) {
            nodo.modifNodoCentral(insertarRecursivo(nodo.verNodoCentral(), tesoro));
        } else {
            nodo.modifNodoDerecho(insertarRecursivo(nodo.verNodoDerecho(), tesoro));
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

        if (tesoroNivelMasProfundo == null || nodo.verTesoro().verValor() > tesoroNivelMasProfundo.getTesoro().verValor()) {
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

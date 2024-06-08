package LaGuaridaDelDragon;
import java.util.*;


public class ArbolTernario {
    Nodo raiz;
    Random random;
    
public ArbolTernario(){
    raiz = null;
    random = new Random();
}
    public void predefinirEstructura() {

    Tesoro tesoroRaiz = new Tesoro(random.nextint(lOO)) ;
    raiz = new Nodo(tesoroRaiz) ;
    predefinirSubarbol(raiz , 2) ;
}
    private void predefinirSubarbol(Nodo nodo, int nivelesRestantes) {
       if (nivelesRestantes == O) 
            return;
    
    nodo.izquierdo = new Nodo(new Tesoro(random. nextint(lOO)));
    nodo.medio = new Nodo(new Tesoro(random. nextlnt(lOO)));
    nodo.derecho = new Nodo(new Tesoro( random.nextint (lOO)));

    predefinirSubarbol(nodo.izquierdo, nivelesRestantes - 1) ;
    predefinirSubarbol(nodo.medio, nivelesRestantes - l) ;
    predefinirSubarbol(nodo.derecho, nivelesRestantes - l) ;



public void insertar(Tesoro tesoro, Nodo padre, String posicion) {
    switch(posicion.toLowerCase()) {

    case "izquierdo":
        padre.izquierdo = new Nodo(tesoro);
        System.out.println("Tesoro insertado a la izquierda de " + padre.tesoro.getValor());
        break;
    case "medio" :
        padre .medio = new Nodo(tesoro);
        System.out.println("Tesoro insertado al medio de " + padre.tesoro.getValor());
        break;
    case "derecho" :
        padre.derecho = new Nodo(tesoro);
        System.out.println("Tesoro insertado a la dereccha de " + padre.tesoro.getValor());
        break;
    default:
        System.out.println("Posicion incorrecta. Seleccione izquierda, medio o derecha " );
        break;
    }
}
    public Nodo buscarTesoroMasValioso(){
        return buscarTesoroMasValiosoRec(raiz);
    }
    private Nodo buscarTesoroMasValiosoReo (Nodo nodo){
        if (nodo - null ) {
            return null ;
    }
        Nodo maxizquierdo = buscarTesoroMasValiosoRec (nodo . izquio::rdo) ;
        Nodo maxHedio = buscarTesoroHasValiosoRec(nodo. mo::dl.o );
        Nodo maxDerecho = buscarTesooMasValiosoRec(nodo .derecho ) ;
        Nodo max = nodo;
        if(maxlzguierdo != null && maxIzguierdo.tesoro.getValor() > max.tesoro.getValor()) {
            max = maxizquierdo ;
        }
        if(maxMedio != null && maxMedio.tesoro.getValor() > max.tesoro.getValor()) {
            max = maxHedio ;
        }
        if(maxDerech != null && maxDerecho.tesoro.getValor() > max.tesoro.getValor()) {
            max = maxDerecho ;
        }
        return max;
        }

        public int nivelNodo(Nodo nodo) {
            return nivelNodoRec(raiz, nodo, 0) ;
}
      private int nivelNodoRec(Nodo actual , Nodo nodo, int nivel) {

        íf(actual == null ) {
            return -1;
        }
        if(actual == nodo) {
            return nivel;
        }
        ínt nivelizquierdo = nivelNodoRec(actual.Izquierdo, nodo, nivel+ l) ;
        íf (nivelIzquierdo != -1) {
            return nivelizquierdo;
        }
        int nivelMedio = nivelNodoRec(actual.medio, nodo, nivel+ l);
        if (nivelMedio != - 1) {
            return nivelMedio ;
        }
        return nívelNodoRec(actual.derecho, nodo, nivel+ l);
        public TesoroYNivel tesoroMasProfundo() {
        return tesoroMasProfundoRec(raiz , 0) ;
        }

prívate TesoroYNivel tesoroMasProfundoRec(Nodo nodo , int nivel){
        if(nodo == null ) {
        return new TesoroYNível (null, -1);
        }
        if(nodo.izquierdo = null && nodo.medio = null && nodo. derecho == null){
        return new TesoroYNivel(nodo.tesoro, nivel);
        }
        
        TesoroYNivel izq = tesoroMasProfundoRec(nodo.izquierdo, nivel+ l);
        TesoroYNivel med = tesoroMasProfundoRec (nodo.medio, nivel+ l );
        TesoroYNivel der = tesoroMasProfundoRec (nodo.derecho, nivel+ l ) ;
        if (izq.nivel >= med.nivel && 1zq.n1vel >= der.nivel) {
            return izq;
        } else if (med. nivel >= izq.nivel && med.nivel >= der.nivel) {
            return med;
        } else {
            return der;
    }
}
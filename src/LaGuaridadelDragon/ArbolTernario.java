package LaGuaridaDelDragon;
import java.util.*;



  public class ArbolTernario {
    Nodo raiz;
    Random random;

    public ArbolTernario() {
        raiz = null;
        random = new Random();
    }

    public void predefinirEstructura() {
        Tesoro tesoroRaiz = new Tesoro(random.nextInt(100));
        raiz = new Nodo(tesoroRaiz);
        predefinirSubarbol(raiz, 2);
    }

    private void predefinirSubarbol(Nodo nodo, int nivelesRestantes) {
        if (nivelesRestantes == 0)
            return;

        nodo.izquierdo = new Nodo(new Tesoro(random.nextInt(100)));
        nodo.medio = new Nodo(new Tesoro(random.nextInt(100)));
        nodo.derecho = new Nodo(new Tesoro(random.nextInt(100)));

        predefinirSubarbol(nodo.izquierdo, nivelesRestantes - 1);
        predefinirSubarbol(nodo.medio, nivelesRestantes - 1);
        predefinirSubarbol(nodo.derecho, nivelesRestantes - 1);
    }

    public void insertar(Tesoro tesoro, int valorPadre, String posicion) {
        Nodo padre = buscarNodo(raiz, valorPadre);
        if (padre != null) {
            switch (posicion.toLowerCase()) {
                case "izquierdo":
                    padre.izquierdo = new Nodo(tesoro);
                    break;
                case "medio":
                    padre.medio = new Nodo(tesoro);
                    break;
                case "derecho":
                    padre.derecho = new Nodo(tesoro);
                    break;
                default:
                    System.out.println("Posición incorrecta. Seleccione izquierdo, medio o derecho.");
            }
        } else {
            System.out.println("El nodo padre no existe.");
        }
    }

    private Nodo buscarNodo(Nodo nodo, int valor) {
        if (nodo == null || nodo.tesoro.getValor() == valor)
            return nodo;

        Nodo encontrado = buscarNodo(nodo.izquierdo, valor);
        if (encontrado == null)
            encontrado = buscarNodo(nodo.medio, valor);
        if (encontrado == null)
            encontrado = buscarNodo(nodo.derecho, valor);

        return encontrado;
    }

    public Nodo buscarTesoroMasValioso() {
        return buscarTesoroMasValiosoRec(raiz);
    }

    private Nodo buscarTesoroMasValiosoRec(Nodo nodo) {
        if (nodo == null)
            return null;

        Nodo maxIzquierdo = buscarTesoroMasValiosoRec(nodo.izquierdo);
        Nodo maxMedio = buscarTesoroMasValiosoRec(nodo.medio);
        Nodo maxDerecho = buscarTesoroMasValiosoRec(nodo.derecho);

        Nodo max = nodo;
        if (maxIzquierdo != null && maxIzquierdo.tesoro.getValor() > max.tesoro.getValor())
            max = maxIzquierdo;
        if (maxMedio != null && maxMedio.tesoro.getValor() > max.tesoro.getValor())
            max = maxMedio;
        if (maxDerecho != null && maxDerecho.tesoro.getValor() > max.tesoro.getValor())
            max = maxDerecho;

        return max;
    }

    public TesoroYNivel tesoroMasProfundo() {
        return tesoroMasProfundoRec(raiz, 0);
    }

    private TesoroYNivel tesoroMasProfundoRec(Nodo nodo, int nivel) {
        if (nodo == null)
            return new TesoroYNivel(null, -1);

        if (nodo.izquierdo == null && nodo.medio == null && nodo.derecho == null)
            return new TesoroYNivel(nodo.tesoro, nivel);

        TesoroYNivel izq = tesoroMasProfundoRec(nodo.izquierdo, nivel + 1);
        TesoroYNivel med = tesoroMasProfundoRec(nodo.medio, nivel + 1);
        TesoroYNivel der = tesoroMasProfundoRec(nodo.derecho, nivel + 1);

        if (izq.nivel >= med.nivel && izq.nivel >= der.nivel)
            return izq;
        else if (med.nivel >= izq.nivel && med.nivel >= der.nivel)
            return med;
        else
            return der;
    }

    public void mostrarEstructura() {
        mostrarEstructuraRec(raiz, 0);
    }

    private void mostrarEstructuraRec(Nodo nodo, int nivel) {
        if (nodo != null) {
            System.out.println("Nivel " + nivel + ": Tesoro con valor " + nodo.tesoro.getValor());
            mostrarEstructuraRec(nodo.izquierdo, nivel + 1);
            mostrarEstructuraRec(nodo.medio, nivel + 1);
            mostrarEstructuraRec(nodo.derecho, nivel + 1);
        }
    }
}
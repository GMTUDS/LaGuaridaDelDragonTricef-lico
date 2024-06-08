package LaGuaridadelDragon;

import java.util.Scanner;
public class juego {
    public static void main(String[] args) {
        ArbolTernario arbol = new ArbolTernario();
        arbol.predefinirEstructura();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a esta aventura");

        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenu");
            System.out.println("1. Insertar tesoro");
            System.out.println("2. Mostrar estructura");
            System.out.println("3. Buscar el tesoro más valioso");
            System.out.println("4. Buscar el tesoro más profundo");
            System.out.println("5. Salir");

            System.out.println("Elige una opción");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el valor del tesoro");
                    int valorTesoro = scanner.nextInt();
                    Tesoro nuevoTesoro = new Tesoro(valorTesoro);

                    System.out.println("Ingrese el valor del nodo padre");
                    int valorPadre = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingrese la posición (izquierdo, medio, derecho)");
                    String posicion = scanner.nextLine();

                    arbol.insertar(nuevoTesoro, valorPadre, posicion);
                    break;
                case 2:
                    arbol.mostrarEstructura();
                    break;
                case 3:
                    Nodo tesoroMasValioso = arbol.buscarTesoroMasValioso();
                    System.out.println("El tesoro más valioso encontrado tiene un valor de: " + tesoroMasValioso.tesoro.getValor());
                    break;
                case 4:
                    TesoroYNivel tesoroMasProfundo = arbol.tesoroMasProfundo();
                    System.out.println("El tesoro más profundo encontrado tiene un valor de: " + tesoroMasProfundo.tesoro.getValor() +
                            " y se encuentra en el nivel: " + tesoroMasProfundo.nivel);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
}           
           
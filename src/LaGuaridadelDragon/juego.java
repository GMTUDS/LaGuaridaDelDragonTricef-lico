<<<<<<< Updated upstream

package LaGuaridadelDragon;

import java.util.Scanner;

public class juego {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolTernario arbol = null;

        System.out.println("Bienvenido a la guarida del dragon tricefalico!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Inicializar el arbol");
            System.out.println("2. Explorar la cueva");
            System.out.println("3. Buscar el tesoro mas valioso");
            System.out.println("4. Buscar el nivel del tesoro mas valioso");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de niveles del arbol: ");
                    int niveles = scanner.nextInt();
                    arbol = new ArbolTernario();
                    arbol.inicializarArbol(niveles);
                    break;
                case 2:
                    if (arbol == null) {
                        System.out.println("El arbol no ha sido inicializado. Por favor, inicialice el arbol antes de explorar la cueva.");
                    } else {
                        explorarCueva(arbol, scanner);
                    }
                    break;
                case 3:
                    buscarTesoroMasValioso(arbol);
                    break;
                case 4:
                    buscarNivelTesoroMasValioso(arbol);
                    break;
                case 5:
                    System.out.println("Usted ha salido del juego");
                    return;
                default:
                    System.out.println("Opcion incorrecta, ingrese una opcion correcta.");
            }
        }
    }

    private static void explorarCueva(ArbolTernario arbol, Scanner scanner) {
    if (arbol == null) {
        System.out.println("El arbol no ha sido inicializado. Por favor, inicialice el arbol antes de explorar la cueva.");
        return;
    }

    System.out.print("Ingrese el nivel donde desea ubicar el tesoro: ");
    int nivel = scanner.nextInt();
    scanner.nextLine(); // Limpiar el búfer de entrada

    if (nivel < 1 || nivel > arbol.getNiveles()) {
        System.out.println("Nivel incorrecto. Por favor, ingrese un nivel correcto.");
        return;
    }

    System.out.print("Ingrese el valor del tesoro: ");
    int valor = scanner.nextInt();
    scanner.nextLine(); 

    System.out.print("Ingrese la descripción del tesoro: ");
    String descripcion = scanner.nextLine();

    Tesoro tesoro = new Tesoro(valor, descripcion);
    arbol.insertarEnNivel(tesoro, nivel);
    System.out.println("Tesoro añadido al nivel " + nivel);
}

    private static void buscarTesoroMasValioso(ArbolTernario arbol) {
        Tesoro tesoroMasValioso = arbol.buscarTesoroMasValioso();
        if (tesoroMasValioso != null) {
            System.out.println("El tesoro mas valioso es:");
            System.out.println("Valor: " + tesoroMasValioso.verValor());
            System.out.println("Descripcion: " + tesoroMasValioso.verDescripcion());
        } else {
            System.out.println("No hay tesoros en la cueva.");
        }
    }

    private static void buscarNivelTesoroMasValioso(ArbolTernario arbol) {
        NivelTesoro tesoroNivelMasProfundo = arbol.TesoroMasValioso();
        if (tesoroNivelMasProfundo != null) {
            System.out.println("El tesoro mas valioso se encuentra en el nivel: " + tesoroNivelMasProfundo.getNivel());
            System.out.println("Valor: " + tesoroNivelMasProfundo.getTesoro().verValor());
            System.out.println("Descripcion: " + tesoroNivelMasProfundo.getTesoro().verDescripcion());
        } else {
            System.out.println("No hay tesoros en la cueva.");
        }
    }
}
=======
>>>>>>> Stashed changes

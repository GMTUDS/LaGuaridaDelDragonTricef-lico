
package LaGuaridadelDragon;

import java.util.Scanner;


public class juego {

   
    public static void main(String[] args) {
           
        
        Scanner scanner = new Scanner(System.in);
        ArbolTernario arbol = new ArbolTernario();

        System.out.println("¡Bienvenido a la guarida del dragón tricefálico!");

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Explorar la cueva");
            System.out.println("2. Buscar el tesoro más valioso");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    explorarCueva(arbol, scanner);
                    break;
                case 2:
                    buscarTesoroMasValioso(arbol);
                    break;
                case 3:
                    System.out.println("Usted ha salido del juego");
                    return;
                default:
                    System.out.println("Opción inválida, ingrese una opción válida.");
            }
        }
    }

    private static void explorarCueva(ArbolTernario arbol, Scanner scanner) {
        System.out.print("Ingrese el valor del tesoro: ");
        int valor = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la descripción del tesoro: ");
        String descripcion = scanner.nextLine();

        Tesoro tesoro = new Tesoro(valor, descripcion);
        arbol.insertar(tesoro);
        System.out.println("Tesoro añadido");
    }

   private static void buscarTesoroMasValioso(ArbolTernario arbol) {
        Tesoro tesoroMasValioso = arbol.buscarTesoroMasValioso();
        if (tesoroMasValioso != null) {
            System.out.println("El tesoro más valioso es:");
            System.out.println("Valor: " + tesoroMasValioso.verValor());
            System.out.println("Descripción: " + tesoroMasValioso.verDescripcion());
        } else {
            System.out.println("No hay tesoros en la cueva.");
        }
    }
   private static void buscarNivelTesoroMasValioso(ArbolTernario arbol) {
    NivelTesoro tesoroNivelMasProfundo = arbol.TesoroMasValioso();
    if (tesoroNivelMasProfundo != null) {
     tesoroNivelMasProfundo = arbol.TesoroMasValioso();  
     System.out.println("El tesoro más valioso se encuentra en el nivel: " + tesoroNivelMasProfundo.getNivel());
        System.out.println("Valor: " + tesoroNivelMasProfundo.getTesoro().verValor());
        System.out.println("Descripción: " + tesoroNivelMasProfundo.getTesoro().verDescripcion());
    } else {
        System.out.println("No hay tesoros en la cueva.");
    }
}
   

}

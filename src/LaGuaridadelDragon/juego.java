

package LaGuaridadelDragon;

import java.util.Scanner;

public class juego{
    public static void main (String[] args){
    ArbolTernario arbol = new ArbolTernario();
    arbol.predefinirEstructura();
    
    
    Scanner scanner =  new Scanner(System.in);
    
        System.out.println("Bienvenido a esta  aventura");
        
        boolean salir=false;
        while(!salir){
            System.out.println("\\nMenu");
            System.out.println("1. Insertar tesoro");
            System.out.println("2. Mostrar estructura");
            System.out.println("3. buscar el tesoro mas valioso");
            System.out.println("4. buscar el tesoro mas profundo");
            System.out.println("5.salir");
            
            System.out.println("elige una opcion");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("ingresa el valor del tesoro");
                    int valorTesoro = scanner.nextInt();
                    Tesoro nuevoTesoro = new Tesoro(valorTesoro);
                    
                    System.out.println("ingrese valor del nodo padre");
                    int valorPadre = scanner.nextInt();
                    scanner.nextLine();
                    
            }
        }
        
    }
}

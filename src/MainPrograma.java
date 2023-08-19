import java.util.Scanner;

public class MainPrograma{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();
        OpcionesExt opciones = new OpcionesExt();
        boolean salir = false;
        

        while (!salir) {
            System.out.println("\n===== Menú =====");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Código Especial");
            System.out.println("7. Salir");
            System.out.print("Ingrese la opción deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    usuario = new Usuario();
                    System.out.println("Se ha creado un nuevo comprador.");
                    break;
                case 2:
                    usuario.realizarCompra();
                    break;
                case 3:
                    opciones.consultarDisponibilidadTotalLocalidades();
                    break;
                case 4:
                    opciones.consultarDisponibilidadIndividual();
                    break;
                case 5:
                    opciones.mostrarDineroGenerado();
                    break;
                case 6:
                    opciones.realizarCompraEspecial();
                    break;
                case 7:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

        scanner.close();
    }
}

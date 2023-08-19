import java.util.Scanner;

public class Usuario {
    
    public void realizarCompra() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la compra de boletos");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese la cantidad de boletos a comprar: ");
        int cantidadBoletos = scanner.nextInt();

        System.out.print("Ingrese su presupuesto máximo: ");
        double presupuestoMaximo = scanner.nextDouble();

        int ticket = obtenerNumeroAleatorio();
        int a = obtenerNumeroAleatorio();
        int b = obtenerNumeroAleatorio();

        if (esAptoParaCompra(ticket, a, b)) {
            Localidad localidadElegida = Localidad.obtenerLocalidadAleatoria();

            if (!localidadElegida.tieneEspacio()) {
                System.out.println("\nLo siento, la localidad elegida no tiene espacio disponible.");
            } else if (!localidadElegida.tieneEspacioSuficiente(cantidadBoletos)) {
                System.out.println("\nNo hay suficiente espacio en la localidad para la cantidad de boletos deseados.");
                cantidadBoletos = localidadElegida.getBoletosDisponibles();
            } else if (!localidadElegida.esPrecioAsequible(localidadElegida.getPrecio() * cantidadBoletos)) {
                System.out.println("\nEl precio de la localidad es mayor al presupuesto. No se puede realizar la compra.");
            } else {
                localidadElegida.venderBoletos(cantidadBoletos);
                double precioBoleto = localidadElegida.getPrecio();

                System.out.println("\nSolicitud de compra exitosa.");
                System.out.println("Ticket generado: " + ticket);
                System.out.println("Detalles de la compra:");
                System.out.println("Nombre: " + nombre);
                System.out.println("Email: " + email);
                System.out.println("Localidad: " + localidadElegida.getNumero());
                System.out.println("Cantidad de boletos: " + cantidadBoletos);
                System.out.println("Presupuesto máximo: $" + presupuestoMaximo);
                System.out.println("Total a pagar: $" + (precioBoleto * cantidadBoletos));
            }
        } else {
            System.out.println("\nEl ticket no es apto para comprar boletos.");
            
        }

        scanner.close();
    }

    public static int obtenerNumeroAleatorio() {
        return (int) (Math.random() * 15000) + 1;
    }

    public static boolean esAptoParaCompra(int ticket, int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return ticket >= min && ticket <= max;
    }
    
    
}

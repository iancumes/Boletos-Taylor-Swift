import java.util.Scanner;

public class OpcionesExt {
    public void consultarDisponibilidadTotalLocalidades() {
        Localidad.localidad1.consultarDisponibilidadTotal();
        Localidad.localidad5.consultarDisponibilidadTotal();
        Localidad.localidad10.consultarDisponibilidadTotal();
    }
    public void consultarDisponibilidadIndividual() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el número de la localidad (1, 5 o 10): ");
    int numeroLocalidad = scanner.nextInt();
    
    Localidad localidadSeleccionada = null;
    if (numeroLocalidad == 1) {
        localidadSeleccionada = Localidad.localidad1;
    } else if (numeroLocalidad == 5) {
        localidadSeleccionada = Localidad.localidad5;
    } else if (numeroLocalidad == 10) {
        localidadSeleccionada = Localidad.localidad10;
    } else {
        System.out.println("Número de localidad no válido.");
        scanner.close();return;
    }

    System.out.println("Disponibilidad Individual:");
    System.out.println("Localidad " + localidadSeleccionada.getNumero() + ":");
    System.out.println("Boletos Disponibles: " + localidadSeleccionada.getBoletosDisponibles());
    scanner.close();
    
}
public void mostrarDineroGenerado() {
    double totalDineroGenerado = 
    Localidad.localidad1.getDineroGenerado() +
        Localidad.localidad5.getDineroGenerado() +
        Localidad.localidad10.getDineroGenerado();

    System.out.println("Dinero total generado: $" + totalDineroGenerado);
}
private boolean esNumeroFibonacci(int numero) {
    int a = 0, b = 1;
    while (b <= numero) {
        if (b == numero) {
            return true;
        }
        int temp = b;
        b = a + b;
        a = temp;
    }
    return false;
}
public void realizarCompraEspecial() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Bienvenido a la compra especial");
    System.out.print("Ingrese su código especial (número de la secuencia de Fibonacci): ");
    int codigoEspecial = scanner.nextInt();

    if (esNumeroFibonacci(codigoEspecial)) {
        Localidad localidadEspecial = Localidad.localidad10;

        if (!localidadEspecial.tieneEspacio()) {
            System.out.println("\nLo siento, la localidad elegida no tiene espacio disponible.");
        } else if (!localidadEspecial.esPrecioAsequible(CompraEspecial.PRECIO_ESPECIAL)) {
            System.out.println("\nEl precio de la localidad es mayor al presupuesto. No se puede realizar la compra.");
        } else {
            localidadEspecial.venderBoletos(1);

            System.out.println("\nSolicitud de compra especial exitosa.");
            System.out.println("Detalles de la compra especial:");
            System.out.println("Código especial: " + codigoEspecial);
            System.out.println("Localidad: " + localidadEspecial.getNumero());
            System.out.println("Total a pagar: $" + CompraEspecial.PRECIO_ESPECIAL);
        }
    } else {
        System.out.println("\nEl código especial no pertenece a la secuencia de Fibonacci.");
    }

    scanner.close();
}

}


import java.util.Random;

public class Localidad {
    private int numero;
    private double precio;
    private int boletosDisponibles;
    private double dineroGenerado;

    public Localidad(int numero, double precio, int boletosDisponibles) {
        this.numero = numero;
        this.precio = precio;
        this.boletosDisponibles = boletosDisponibles;
        this.dineroGenerado = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecio() {
        return precio;
    }
    public double getDineroGenerado() {
        return dineroGenerado;
    }

    public int getBoletosDisponibles() {
        return boletosDisponibles;
    }

    public boolean esAptaParaCompra(int ticket) {
        return ticket >= (numero * 5000) && ticket < ((numero + 1) * 5000);
    }

    public boolean tieneEspacio() {
        return boletosDisponibles > 0;
    }

    public boolean tieneEspacioSuficiente(int cantidadBoletos) {
        return boletosDisponibles >= cantidadBoletos;
    }

    public boolean esPrecioAsequible(double presupuestoMaximo) {
        return precio <= presupuestoMaximo;
    }

    public void venderBoletos(int cantidadBoletos) {
        boletosDisponibles -= cantidadBoletos;
        dineroGenerado += precio * cantidadBoletos;
    }
    public void consultarDisponibilidadTotal() {
        System.out.println("       ");
        System.out.println("Disponibilidad Total:");
        System.out.println("Localidad " + getNumero() + ":");
        System.out.println("Boletos Vendidos: " + (20 - getBoletosDisponibles()));
        System.out.println("Boletos Disponibles: " + getBoletosDisponibles());
    }
    
        
    public static  Localidad localidad1 = new Localidad(1, 100.0, 20);
    public static  Localidad localidad5 = new Localidad(5, 500.0, 20);
    public static  Localidad localidad10 = new Localidad(10, 1000.0, 20);

    public static Localidad obtenerLocalidadAleatoria() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(3); // Genera un número aleatorio entre 0 y 2

        if (numeroAleatorio == 0) {
            return localidad1;
        } else if (numeroAleatorio == 1) {
            return localidad5;
        } else {
            return localidad10;
        }
    }
}

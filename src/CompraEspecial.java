public class CompraEspecial {
    private int codigo;
    private double precio;
    public static final double PRECIO_ESPECIAL = 20000.0;

    public CompraEspecial(int codigo) {
        this.codigo = codigo;
        this.precio = PRECIO_ESPECIAL;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }
}

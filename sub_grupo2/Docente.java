import java.util.Calendar;

/**
 * Docente: un tipo de Socio de la biblioteca.
 * Hereda todo de Socio y agrega el area en la que trabaja.
 */
public class Docente extends Socio {

    // area en la que trabaja el docente (dato propio de esta clase)
    private String area;

    /**
     * Constructor: recibe dni, nombre y area
     * Le pasa a Socio el dni, el nombre y los 5 días de prestamo
     * con los que empiezan todos los docentes.
     */
    public Docente(int p_dniSocio, String p_nombre, String p_area) {
        super(p_dniSocio, p_nombre, 5);
        this.area = p_area;
    }

    /**
     * Devuelve true si el docente nunca tuvo ni tiene un prestamo vencido
     * Recorre TODOS sus prestamos, los devueltos y los que todavia tiene
     * Si el libro no se devolvio, compara con la fecha de hoy
     * Si ya se devolvio, compara con la fecha en que lo devolvio
     */
    public boolean esResponsable() {
        Calendar hoy = Calendar.getInstance();
        for (Prestamo p : this.getPrestamos()) {
            Calendar fecha;
            if (p.getFechaDevolucion() == null) {
                fecha = hoy;
            } else {
                fecha = p.getFechaDevolucion();
            }
            if (p.vencido(fecha)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Suma dias de prestamo al docente (premio a la responsabilidad)
     * Toma los dias actuales y le agrega los que llegan por parametro
     */
    public void cambiarDiasDePrestamo(int p_dias) {
        this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
    }

    /**
     * Sobreescribe puedePedir() de Socio.
     * El docente no tiene limite de libros, solo no puede tener
     * prestamos vencidos, que es justo lo que ya revisa Socio
     */
    public boolean puedePedir() {
        return super.puedePedir();
    }

    /**
     * Implementa el metodo abstracto de Socio.
     * Devuelve el tipo de socio como texto.
     */
    public String soyDeLaClase() {
        return "Docente";
    }
}

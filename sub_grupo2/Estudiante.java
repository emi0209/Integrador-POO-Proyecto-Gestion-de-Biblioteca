/**
 * Estudiante: un tipo de Socio de la biblioteca.
 * Hereda todo de Socio y agrega la carrera que estudia.
 */
public class Estudiante extends Socio {

    // Carrera que cursa el estudiante (dato propio de esta clase)
    private String carrera;

    /**
     * Constructor: recibe dni, nombre y carrera.
     * El dni y el nombre se los pasa a Socio con super, junto con
     * los 20 dias de prestamo que tienen los estudiantes.
     */
    public Estudiante(int p_dniSocio, String p_nombre, String p_carrera) {
        super(p_dniSocio, p_nombre, 20);
        this.carrera = p_carrera;
    }

    /**
     * Sobreescribe puedePedir() de Socio.
     * Un estudiante puede pedir si no tiene prestamos vencidos
     * (lo pregunta a Socio con super) y si no tiene mas de 3 libros.
     */
    public boolean puedePedir() {
        return super.puedePedir() && this.cantLibrosPrestados() <= 3;
    }

    /**
     * Implementa el metodo abstracto de Socio.
     * Devuelve el tipo de socio como texto.
     */
    public String soyDeLaClase() {
        return "Estudiante";
    }
}

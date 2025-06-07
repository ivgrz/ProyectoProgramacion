public class Gato {
    private int id;
    private String nombre;
    private String raza;
    private int edad;
    private boolean adoptado;

    /**
     * Constructor vacío
     * Se necesita cuando se construyen objetos sin pasar parámetros.
     */
    public Gato() {}

    /**

     * @param nombre Nombre del gato.
     * @param raza Raza del gato.
     * @param edad Edad en años.
     * @param adoptado Si el gato está adoptado o no.
     */
    public Gato(String nombre, String raza, int edad, boolean adoptado) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.adoptado = adoptado;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    /**
     * Sobrescribe el método toString de Object.
     * Devuelve una cadena de texto con la información del gato de forma legible.
     * @return Una cadena con el nombre, raza, edad y estado de adopción.
     */
    @Override
    public String toString() {
        // El operador ternario elige el texto según si el gato está adoptado o no
        return nombre + " (" + raza + "), " + edad + " años - " +
                (adoptado ? "Adoptado" : "Disponible");
    }



}

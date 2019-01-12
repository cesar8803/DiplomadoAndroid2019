public class Persona {


    private String nombre;
    private String tonodepiel;
    private int edad;
    private boolean genero;
    private String fechadenacimiento;
    private double estatura;
    private double peso;

    // Declaración de un metodo (Representa una acción o comportamiento de una clase/ objeto)
    public String quienSoy(){

            return "Hola mi nombre y edad es: " + nombre + edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTonodepiel() {
        return tonodepiel;
    }

    public void setTonodepiel(String tonodepiel) {
        this.tonodepiel = tonodepiel;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public String getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(String fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}

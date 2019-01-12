public class Estudiante extends Persona {

private  int matricula;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public GradoEstudio getGradoEstudio() {
        return gradoEstudio;
    }

    public void setGradoEstudio(GradoEstudio gradoEstudio) {
        this.gradoEstudio = gradoEstudio;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    private GradoEstudio gradoEstudio; //Se llama a la variable gradoEstudio de la variable que nace en la clase GradoEstudio
private String escuela;



}

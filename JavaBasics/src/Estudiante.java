import java.util.Random;

public class Estudiante extends Persona implements  Evaluable{


    private int matricula;
    private GradoEstudio gradoEstudio;
    private String escuela;

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

    @Override
    public int evalua() {

        Random rn = new Random();
        int answer = rn.nextInt(10) + 1;

        return answer;
    }
}

import java.util.Random;

public class EstudianteMatematicas extends  Estudiante{

    private String especialidadMatematicas;


    @Override
    public int estudiaMaterias(int numberTotalMaterias) {
        Random rn = new Random();
        int answer = rn.nextInt(numberTotalMaterias- (numberTotalMaterias/4)) + (int) numberTotalMaterias/4;
        return answer;
    }
}

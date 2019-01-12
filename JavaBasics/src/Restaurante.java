import java.util.Random;

public class Restaurante  implements Evaluable{

    private String nombre;

    @Override
    public int evalua() {

        Random rn = new Random();
        int answer = rn.nextInt(5) + 1;

        return answer;    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

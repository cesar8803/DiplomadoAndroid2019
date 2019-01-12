public class Luncher {


    public static void main(String args[]){

        System.out.println("Hola!  K ace");

        //Selecciono el tipo persona
        //le coloco un nombre (referencia) a mi objeto
        //Invoco al constructor de la clase
        // Un constructor es una subrutina/funcion cuya misión
        // es inicializar un objeto de una clase.
        // En el constructor se asignan los valores iniciales del nuevo objeto.

        Persona manuel = new Persona();

        manuel.setNombre("Manuel Benjamin");
        manuel.setEdad(32);
        manuel.setEstatura(1.82);
        manuel.setGenero(true);
        manuel.setPeso(85);

        String saludoManuel = manuel.quienSoy();

        System.out.println(saludoManuel);


        Persona christian = new Persona();

        christian.setNombre("Christian");
        christian.setEdad(38);
        christian.setEstatura(1.69);
        christian.setGenero(true);
        christian.setPeso(75);

        String saludoChris = christian.quienSoy();

        System.out.println(saludoChris);


    }

}

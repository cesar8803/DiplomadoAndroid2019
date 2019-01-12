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

        Estudiante eduardo = new Estudiante();

        eduardo.setNombre("Eduardo");
        eduardo.setEdad(38);
        eduardo.setEstatura(1.69);
        eduardo.setGenero(true);
        eduardo.setPeso(75);
        eduardo.setMatricula(12345678);
        eduardo.setEscuela("UVM");
        GradoEstudio gradoEstudio = new GradoEstudio(4,8);
        eduardo.setGradoEstudio(gradoEstudio);


        String saludoLalo = eduardo.quienSoy();

        System.out.println(saludoLalo);



    }

}

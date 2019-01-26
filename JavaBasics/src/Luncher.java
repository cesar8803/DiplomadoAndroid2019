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




        String saludoEduardo = eduardo.quienSoy();

        System.out.println(saludoEduardo+ " mi evaluación es: "+eduardo.evalua());
        System.out.println(saludoEduardo+ " las materias que paso eduardo son: "+eduardo.estudiaMaterias(8));


        Restaurante bellinis = new Restaurante();
        bellinis.setNombre("Bellinis");

        System.out.println(bellinis.getNombre()+ " la evaluación es: "+bellinis.evalua());




        EstudianteMatematicas fernando = new EstudianteMatematicas();
        fernando.setNombre("Fernando");
        fernando.setEdad(38);
        fernando.setEstatura(1.69);
        fernando.setGenero(true);
        fernando.setPeso(75);
        fernando.setMatricula(12345678);
        fernando.setEscuela("UVM");
        GradoEstudio gradoEstudioFer = new GradoEstudio(4,8);
        fernando.setGradoEstudio(gradoEstudioFer);

        String saludoFernando = fernando.quienSoy();

        System.out.println(saludoFernando+ " mi evaluación es: "+fernando.evalua());
        System.out.println(saludoFernando+ " las materias que paso fernando son: "+fernando.estudiaMaterias(8));










    }

}

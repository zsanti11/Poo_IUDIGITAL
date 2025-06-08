import java.util.*;
import java.util.stream.*;

public class AnalisisPersonas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();

        System.out.print("¿Cuántas personas deseas ingresar?: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Persona " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Apellido: ");
            String apellido = sc.nextLine();
            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());
            System.out.print("Género (masculino/femenino): ");
            String genero = sc.nextLine();
            System.out.print("Sueldo por hora: ");
            double sueldoHora = Double.parseDouble(sc.nextLine());
            System.out.print("Cargo: ");
            String cargo = sc.nextLine();

            personas.add(new Persona(nombre, apellido, edad, genero, sueldoHora, cargo));
        }

        // a. Cantidad
        System.out.println("Cantidad total: " + personas.size());

        // b. Promedio edad
        double promedio = personas.stream().mapToInt(Persona::getEdad).average().orElse(0);
        System.out.println("Promedio de edad: " + promedio);

        // c. Mayores de edad
        long mayores = personas.stream().filter(p -> p.getEdad() >= 18).count();
        System.out.println("Mayores de edad: " + mayores);

        // d. Nombres que empiezan con "A"
        System.out.println("Nombres que empiezan con 'A':");
        personas.stream().filter(p -> p.getNombre().startsWith("A"))
                .forEach(p -> System.out.println("\t" + p.getNombre()));

        // e. Apellidos que contienen 'M'
        System.out.println("Apellidos que contienen 'M':");
        personas.stream().filter(p -> p.getApellido().toLowerCase().contains("m"))
                .forEach(p -> System.out.println("\t" + p.getApellido()));

        sc.close();
    }
}

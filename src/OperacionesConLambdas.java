import java.util.*;
import java.util.stream.*;

public class OperacionesConLambdas {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Juan", "Morales", 35, "masculino", 5625000, "director"),
                new Persona("Ana", "Martínez", 30, "femenino", 4000000, "desarrollador"),
                new Persona("Pedro", "Mendoza", 25, "masculino", 3200000, "desarrollador"),
                new Persona("Luisa", "Mejía", 28, "femenino", 3800000, "desarrollador")
        );

        // a. Sueldo de directores masculinos por 8 horas
        personas.stream()
                .filter(p -> p.getGenero().equals("masculino") && p.getCargo().equals("director"))
                .peek(p -> System.out.print("Nombre: " + p.getNombre() + " " + p.getApellido() + " "))
                .map(p -> p.getSueldoHora() * 8)
                .forEach(sueldo -> System.out.println("Sueldo por 8 horas: $" + sueldo));

        // b. Primera mujer desarrolladora
        Optional<Persona> mujerDev = personas.stream()
                .filter(p -> p.getCargo().equals("desarrollador") && p.getGenero().equals("femenino"))
                .findFirst();
        mujerDev.ifPresent(p -> System.out.println("Primera desarrolladora mujer: " + p.getNombre() + " " + p.getApellido()));

        // c. Desarrollador que más gana
        Optional<Persona> masGana = personas.stream()
                .filter(p -> p.getCargo().equals("desarrollador"))
                .max(Comparator.comparing(Persona::getSueldoHora));
        masGana.ifPresent(p -> System.out.println("El desarrollador que más gana: " + p.getNombre() + " $" + p.getSueldoHora()));

        // d. Mujeres ordenadas por nombre
        System.out.println("Mujeres ordenadas por nombre:");
        personas.stream()
                .filter(p -> p.getGenero().equals("femenino"))
                .sorted(Comparator.comparing(Persona::getNombre))
                .forEach(p -> System.out.println(p.getNombre() + " " + p.getApellido()));
    }
}

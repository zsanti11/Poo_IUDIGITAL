import java.util.*;

public class ClasificadorAnimales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Animal> animales = new ArrayList<>();
        Map<String, List<Animal>> clasificacion = new TreeMap<>();

        System.out.print("¿Cuántos animales deseas ingresar?: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Animal " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Tipo (terrestre, aéreo, acuático): ");
            String tipo = sc.nextLine().toLowerCase();
            System.out.print("Género (masculino, femenino): ");
            String genero = sc.nextLine().toLowerCase();

            Animal animal = new Animal(nombre, tipo, genero);
            animales.add(animal);
            clasificacion.computeIfAbsent(tipo, k -> new ArrayList<>()).add(animal);
        }

        System.out.println("\n=== Clasificación de Animales ===");
        clasificacion.forEach((tipo, lista) -> {
            System.out.println(tipo.substring(0, 1).toUpperCase() + tipo.substring(1) + ":");
            lista.forEach(a -> System.out.println("\t" + a.getNombre()));
        });

        sc.close();
    }
}

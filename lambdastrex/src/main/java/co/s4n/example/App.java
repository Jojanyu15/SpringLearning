package co.s4n.example;

import co.s4n.example.model.Persona;
import co.s4n.example.model.Producto;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {

    private List<Producto> productos;
    private boolean anymatch1;

    public static void main(String[] args) {
        /*
         *  Productos
         */
        Producto p1 = new Producto(1, "Bandeja paisa", 30000);
        Producto p2 = new Producto(2, "Caldo de papa", 24000);
        Producto p3 = new Producto(3, "Changua", 10000);
        Producto p4 = new Producto(4, "Lomo de res", 4000);

        /*
         *       Personas
         */
        Persona per1 = new Persona(1, "Alberto", LocalDate.of(1998, 12, 6));
        Persona per2 = new Persona(2, "David", LocalDate.of(1979, 12, 6));
        Persona per3 = new Persona(3, "Alexander", LocalDate.of(1989, 12, 6));
        Persona per4 = new Persona(4, "Carlos", LocalDate.of(1999, 12, 6));

        List<Persona> personas = Arrays.asList(per1, per2, per3, per4);
        List<Producto> productos = Arrays.asList(p1, p2, p3, p4);

        // 1. forEach Funcional
        personas.forEach(System.out::println);

        // 2. filter
        /*
         * Stream funciona para trabajar de forma declarativa con colecciones y operar con ellas.
         */
        List<Persona> from1999 = personas.stream()
                //Filtra por medio de una funcion lambda las personas que nacieron desde el 1999
                .filter(persona -> persona.getBirthdate().getYear() >= 1999)
                //Collect  recolecta el resultado y lo retorna en forma de lista por medio de toList();
                .collect(Collectors.toList());

        System.out.println("\nImprimiendo personas que nacieron desde el 1999...\n");
        from1999.forEach(System.out::println);

        // 3. Map
        /*
         * Map nos permite obtener un resultado con un tipo de dato distinto al origen del objeto en el que se opera
         * ejemplo operar sobre una lista de enteros y retornar una lista de dobles
         */
        List<Integer> from1999map = personas.stream()
                //Obtiene un entero que corresponde al año de nacimiento de las personas.
                .map(persona -> persona.getBirthdate().getYear())
                //Collect  recolecta el resultado y lo retorna en forma de lista por medio de toList();
                .collect(Collectors.toList());

        System.out.println("\nImprimiendo los años de nacimiento de la lista de personas...\n");
        from1999map.forEach(System.out::println);

        // 3. Filter y map
        /*
         * Nos permite filtrar y a la vez transformar el tipo a partir del resultado del filtro
         */
        List<Integer> from1990MF = personas.stream()
                // filtra a las personas que cumplen la condición de haber desde el 1990
                .filter(p -> p.getBirthdate().getYear() >= 1990)
                //Obtiene un entero que corresponde al año de nacimiento de las personas.
                .map(persona -> persona.getBirthdate().getYear())
                //Collect  recolecta el resultado y lo retorna en forma de lista por medio de toList();
                .collect(Collectors.toList());

        System.out.println("\nImprimiendo la lista de personas que nacieron desde el 1990...\n");
        from1990MF.forEach(System.out::println);

        // 4. Sorted y comparators
        /*
         * Permite ordenar una lista dependiendo del elemento a comparar
         */
        //Comparador que compara por el atributo name.
        Comparator<Persona> porNombre = (Persona pr1, Persona pr2) -> pr1.getName().compareTo(pr2.getName());

        List<Persona> sorted = personas
                .stream()
                //metodo sorted que recibe un comparador.
                .sorted(porNombre)
                .collect(Collectors.toList());

        System.out.println("\nImprimiendo la lista de personas ordenadas por nombre...\n");
        sorted.forEach(System.out::println);

        // 5. Match
        /*
         * anyMatch
         * No evalua todo el contenido, solo busca la primera coincidencia y retorna true o false.
         */
        boolean anymatch = personas.stream().anyMatch(p -> p.getBirthdate().getYear() >= 1990);

        /*
         * allMatch
         * evalua todo el contenido buscando que TODOS los elemntos coincidan con la coindición.
         */
        boolean allmatch = personas.stream().allMatch(p -> p.getBirthdate().getYear() >= 1990);

        /*
         * noneMatch
         * evalua todo el contenido buscando que NINGUNO de los elemntos coincidan con la coindición.
         */
        boolean nonematch = personas.stream().noneMatch(p -> p.getBirthdate().getYear() >= 1990);

        // 5. Limit / skip
        /*
         * skip, elimina la n cantidad de elementos desde el inicio hasta el número del indice.
         * también puede hacerse dependiendo de un predicado
         */
        List<Persona> skipped = personas
                .stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("\nImprimiendo la lista con la función skip(2)...\n");
        skipped.forEach(System.out::println);

        /*
         * limit, elimina la n cantidad de elementos desde el inicio hasta el número del indice.
         * también puede hacerse dependiendo de un predicado
         */
        List<Persona> limited = personas
                .stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("\nImprimiendo la lista con la función limit(2)...\n");
        limited.forEach(System.out::println);

        // 6. Collectors
        /*
         * groupBy
         */
        Map<String, List<Producto>> groupBy = productos
                .stream()
                .filter(producto -> producto.getPrice() > 20)
                .collect(Collectors.groupingBy(Producto::getName));
        System.out.println("\nImprimiendo el Map con la función groupBy...\n");
        System.out.println(groupBy);

        /*
         * groupBy
         */
        Map<String, Long> countBy = productos
                .stream()
                .collect(Collectors
                        .groupingBy(Producto::getName, Collectors.counting()));

        System.out.println("\nImprimiendo el Map con la función group by retornando el numero de elemtnos repetidos...\n");
        System.out.println(countBy);

        /*
         * groupBy usando summing, lo que hace es ubicar los elementos repetidos y sumar el atributo que puede ser
         * un valor numérico.
         */
        Map<String, Double> summing = productos
                .stream()
                .collect(Collectors
                        .groupingBy(Producto::getName, Collectors.summingDouble(Producto::getPrice)));
        System.out.println("\nImprimiendo el Map con la función group by usando summingDouble...\n");
        System.out.println(summing);

        //7. Summarizing
        DoubleSummaryStatistics summarizing = productos
                .stream()
                .collect(Collectors
                        .summarizingDouble(Producto::getPrice));
        System.out.println("\nImprimiendo el Map con la función Collectors usando summarizingDouble...\n");
        System.out.println(summarizing);

        //8. Optional similar a option en SCALA

        Optional<Double> sum = productos
                .stream()
                .map(Producto::getPrice)
                .reduce(Double::sum);

        System.out.println("\nImprimiendo el Map con la función reduce (optional)...\n");
        System.out.println(sum);

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateFolder = zonedDateTime.format(formatter);

        File file = Paths.get("/home/johan/zoneminder/events/" + File.separator + "Monitor-2" + File.separator + dateFolder
                    + File.separator + "1" + File.separator).toFile();
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
    }
}

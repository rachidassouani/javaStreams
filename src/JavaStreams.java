import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.*;

public class JavaStreams {

    public static void main(String[] args) throws IOException {

        // 1- Integer Stream.
        IntStream
                .range(1, 10)
                .forEach(out::print);
                out.println();
        // 2- Integer Stream with skip.
        IntStream
                .range(1, 10)
                .skip(2) // skip the first two elements.
                .forEach(out::print);

        // 3- Integer Stream with sum
        out.println( IntStream.range(1, 10).sum() );

        //4- Stream of sorted and findFirst.
        Stream.of("Morocco", "UK", "USA", "Canada")
                .sorted()
                .findFirst()
                .ifPresent(out::println);

        //5- Stream from Array ( sort, filter and print ).
        String[] names = {"Rachid", "Mehdi", "Mustapha", "Zakaria", "Hajar"};
        Stream.of(names) // we can also use Arrays.stream(names)
                .filter(name -> name.startsWith("M"))
                .sorted()
                .forEach(out::print);
        out.println();

        //6- average of squares of an int array.
        Arrays.stream(new int[] {4, 3, 6, 0, 7, 1})
                .map(num -> num * num)
                .average()
                .ifPresent(out::print);
        out.println();

        // 7- Stream from List, filter and print it.
        List<String> people = Arrays.asList("Rachid", "Mehdi", "Mustapha", "Zakaria", "Hajar");
            people.stream()
                    .map(String::toLowerCase)
                    .filter(name-> name.startsWith("m"))
                    .forEach(out::println);

        // 8- Stream row from text file, sort, filter and print
        Stream<String> carNames = Files.lines(Paths.get("carNames.txt"));
        carNames.sorted()
                .filter(carName -> carName.length()>4)
                .forEach(System.out::println);
        carNames.close();
        out.println();

        // 9- Stream row from text file and save it to List
        List<String> carNames2 = Files.lines(Paths.get("carNames.txt"))
               .filter(carName-> carName.contains("BMW"))
               .collect(Collectors.toList());
        carNames2.forEach(System.out::println);

        // 10-

    }


}

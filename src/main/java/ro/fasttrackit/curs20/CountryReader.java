package ro.fasttrackit.curs20;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountryReader {

    public static List<Country> countryReader(String fileName) throws FileNotFoundException {
        List<Country> result = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader(fileName));
        while (scanner.hasNext()) {
            result.add(getCountry(scanner.nextLine()));
        }
        return result;
    }

    private static Country getCountry(String line) {
        String[] tokens = line.split("\\|");
        return new Country(tokens[0],
                tokens[1],
                Long.parseLong(tokens[2]),
                Long.parseLong(tokens[3]),
                tokens[4],
                tokens.length > 5 ? getNeighbours(tokens[5]) : new ArrayList<String>());
    }

    private static List<String> getNeighbours(String neighbours) {
        return Arrays.asList(neighbours.split("~"));
    }
}

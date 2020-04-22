package ro.fasttrackit.curs20;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Country> list = CountryReader.countryReader("src/main/resources/countries.txt");
        CountryService countryService = new CountryService(list);
        System.out.println(countryService.getCountryNames());
        System.out.println(countryService.getCapital("Bulgaria"));
        System.out.println(countryService.getContinent("Africa"));
        System.out.println(countryService.getNeighbours("Romania"));
        System.out.println(countryService.getCountriesHigherFrom("Europe", 50_000_000));
        System.out.println(countryService.getNeighboursXbutNotY("ROU", "HUN"));
        System.out.println(countryService.sortContByPop("Europe"));
        System.out.println(countryService.sortContByArea("Europe"));
        System.out.println(countryService.mapCountryToPop());
        System.out.println(countryService.mapContinentToCountry());
        System.out.println(countryService.sortedMapContinentToCountry());
    }
}

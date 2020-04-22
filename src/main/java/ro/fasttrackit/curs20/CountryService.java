package ro.fasttrackit.curs20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class CountryService {
    private final List<Country> countries;

    public CountryService(List<Country> countries) {
        this.countries = countries == null ? new ArrayList<Country>() : new ArrayList<Country>(countries);
    }

    private static Long biggerPop(Long pop1, Long pop2) {
        return pop1 > pop2 ? pop1 : pop2;
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public List<String> getCountryNames() {
        return countries.stream()
                .map(Country::getName)
                .collect(toList());
    }


    public String getCapital(String countryName) {
        return countries.stream()
                .filter(country -> country.getName().equals(countryName))
                .findFirst()
                .map(Country::getCapital).orElse("Country does not exist");
    }

    public long getPop(String countryName) {
        return countries.stream()
                .filter(country -> country.getName().equals(countryName))
                .findFirst()
                .map(Country::getPop).orElse(0L);
    }

    public List<Country> getContinent(String continent) {
        return countries.stream()
                .filter(c -> c.getContinent().equals(continent))
                .collect(toList());
    }

    public List<String> getNeighbours(String country) {
        return countries.stream()
                .filter(c -> c.getName().equalsIgnoreCase(country))
                .findFirst()
                .map(Country::getNeighbours)
                .orElse(new ArrayList<>());
    }

    public List<Country> getCountriesHigherFrom(String continent, int pop) {
        return countries.stream()
                .filter(c -> c.getContinent().equalsIgnoreCase(continent) && c.getPop() > pop)
                .collect(toList());
    }

    public List<Country> getNeighboursXbutNotY(String neigh, String notNeigh) {
        return countries.stream()
                .filter(c -> c.getNeighbours().contains(neigh) && !(c.getNeighbours().contains(notNeigh)))
                .collect(toList());
    }

    public List<Country> sortContByPop(String cont) {
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(cont))
                .sorted(Comparator.comparing(Country::getPop))
                .collect(toList());
    }

    public List<Country> sortContByArea(String cont) {
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(cont))
                .sorted(Comparator.comparing(Country::getArea))
                .collect(toList());
    }

    public Map<String, Long> mapCountryToPop() {
        return countries.stream()
                .collect(toMap(Country::getName, Country::getPop, CountryService::biggerPop));
    }

    public Map<String, List<Country>> mapContinentToCountry() {
        return countries.stream()
                .collect(toMap(Country::getContinent,
                        c -> List.of(c),
                        (c1, c2) -> Stream.concat(c1.stream(), c2.stream())
                                .collect(toList())
                ));
    }

    public Map<String, List<Country>> sortedMapContinentToCountry() {
        return countries.stream()
                .collect(toMap(Country::getContinent,
                        c -> List.of(c),
                        (c1, c2) -> Stream.concat(c1.stream(), c2.stream())
                                .sorted(Comparator.comparing(Country::getPop))
                                .collect(toList())
                ));
    }

}

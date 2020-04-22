package ro.fasttrackit.curs20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CountryServiceTest {
    private CountryService countryService;

    @BeforeEach
    void setup() {
        List<Country> countries = List.of(new Country("Romania", "Bucuresti", 19_000_000, 500_0000, "Europe", List.of("MLD", "UKR", "HUN", "BLG")),
                new Country("Brazil", "Rio de Janeiro", 210_000_000, 1_200_0000, "America de Sud", List.of("ARG", "URG", "BOL", "PER")),
                new Country("Ungaria", "Budapesta", 7_000_000, 300_0000, "Europe", List.of("MLD", "UKR", "ROU", "BLG")),
                new Country("Franta", "Paris", 65_000_000, 1_000_0000, "Europe", List.of("GER", "ITA", "SPN", "BEL")),
                new Country("Germania", "Berlin", 80_000_000, 800_0000, "Europe", List.of("ITA", "FRA", "AUS", "BEL"))
        );
        countryService = new CountryService(countries);
    }

    @Test
    @DisplayName("When creating an null countryService THE create emptyList")
    void givingNull() {
        CountryService countryService = new CountryService(null);
        assertThat(countryService.getCountries()).isEmpty();
    }

    @Test
    @DisplayName("When getCountryNames THEN return List of country names")
    void getCountryNames() {
        assertThat(countryService.getCountryNames()).containsExactly("Romania", "Brazil", "Ungaria", "Franta", "Germania");
    }

    @Test
    @DisplayName("When getting a country capital and country does not exist THEN return country does not exist")
    void getImaginaryCapital() {
        assertThat(countryService.getCapital("Wakanda")).isEqualTo("Country does not exist");
    }

    @Test
    @DisplayName("When getting a country capital THEN return capital")
    void getCapital() {
        assertThat(countryService.getCapital("Romania")).isEqualTo("Bucuresti");
    }

    @Test
    @DisplayName("When getting a country pop and country does not exist THEN return 0")
    void getImaginaryPop() {
        assertThat(countryService.getPop("Wakanda")).isEqualTo(0);
    }

    @Test
    @DisplayName("When getting a population capital THEN return population")
    void getPop() {
        assertThat(countryService.getPop("Romania")).isEqualTo(19_000_000);
    }
}
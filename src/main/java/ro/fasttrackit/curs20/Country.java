package ro.fasttrackit.curs20;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Country {
    private final String name;
    private final String capital;
    private final long pop;
    private final long area;
    private final String continent;
    private final List<String> neighbours;

    public Country(String name, String capital, long pop, long area, String continent, List<String> neighbours) {
        this.name = name;
        this.capital = capital;
        this.pop = pop;
        this.area = area;
        this.continent = continent;
        this.neighbours = neighbours;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public long getPop() {
        return pop;
    }

    public long getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }

    public List<String> getNeighbours() {
        return Collections.unmodifiableList(neighbours);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return getPop() == country.getPop() &&
                getArea() == country.getArea() &&
                Objects.equals(getName(), country.getName()) &&
                Objects.equals(getCapital(), country.getCapital()) &&
                Objects.equals(getContinent(), country.getContinent()) &&
                Objects.equals(getNeighbours(), country.getNeighbours());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCapital(), getPop(), getArea(), getContinent(), getNeighbours());
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", pop=" + pop +
                ", area=" + area +
                ", continent='" + continent + '\'' +
                ", neighbours=" + neighbours +
                '}';
    }
}

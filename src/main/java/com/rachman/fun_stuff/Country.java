package com.rachman.fun_stuff;

public class Country implements Comparable<Country>, Cloneable {
    private String name;
    private String continent;
    private int population;
    private String abbreviation;

    public Country() {
        this("Unknown", "Unknown", 0, "Unknown");
    }

    public Country(String name, String continent, int population, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.continent = continent;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public int compareTo(Country o) {
        return this.name.compareTo(o.name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}

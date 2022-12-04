package cz.martin.models;

public class CountryFilter {
    private String name = "";
    private String continent = "";
    private int areaFrom = 0;
    private int areaTo = 0;
    private long populationFrom = 0;
    private long populationTo = 0;
    private long hdpFrom = 0;
    private long hdpTo = 0;

    public int getValidAreaTo() {
        return this.areaTo != 0 ? this.areaTo : Integer.MAX_VALUE;
    }

    public long getValidPopulationTo() {
        return this.populationTo != 0 ? this.populationTo : Long.MAX_VALUE;
    }

    public long getValidHDPTo() {
        return this.hdpTo != 0 ? this.hdpTo : Long.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent != null ? continent : "";
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getAreaFrom() {
        return areaFrom;
    }

    public void setAreaFrom(int areaFrom) {
        this.areaFrom = areaFrom;
    }

    public int getAreaTo() {
        return areaTo;
    }

    public void setAreaTo(int areaTo) {
        this.areaTo = areaTo;
    }

    public long getPopulationFrom() {
        return populationFrom;
    }

    public void setPopulationFrom(long populationFrom) {
        this.populationFrom = populationFrom;
    }

    public long getPopulationTo() {
        return populationTo;
    }

    public void setPopulationTo(long populationTo) {
        this.populationTo = populationTo;
    }

    public long getHdpFrom() {
        return hdpFrom;
    }

    public void setHdpFrom(long hdpFrom) {
        this.hdpFrom = hdpFrom;
    }

    public long getHdpTo() {
        return hdpTo;
    }

    public void setHdpTo(long hdpTo) {
        this.hdpTo = hdpTo;
    }
}

package com.gauvain.ghibli.model;

public class Location {

    private String name;
    private String climate;
    private String terrain;
    private String surfaceWater;

    public Location(String name, String climate, String terrain, String surfaceWater) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.surfaceWater = surfaceWater;
    }

    public String getName() {
        return name;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }
}

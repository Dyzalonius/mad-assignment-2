package com.example.geoguessswipe;

public class GeoLocation {

    private String name;
    private boolean inEurope;
    private int image;

    public GeoLocation(String name, boolean inEurope, int image) {
        this.name = name;
        this.inEurope = inEurope;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public boolean isInEurope() {
        return inEurope;
    }
}

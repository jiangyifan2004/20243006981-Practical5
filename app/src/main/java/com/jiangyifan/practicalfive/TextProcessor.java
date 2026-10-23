package com.jiangyifan.practicalfive;

public class TextProcessor {

    public String processMunicipality(String municipality) {
        // A null result means that the input is invalid.
        if (municipality == null) {
            return null;
        }

        String name = municipality.trim();

        if (name.isEmpty()) {
            return null;
        }

        // Accept any letter case and return the correct city name.
        if (name.equalsIgnoreCase("Beijing")) {
            return "Beijing";
        } else if (name.equalsIgnoreCase("Shanghai")) {
            return "Shanghai";
        } else if (name.equalsIgnoreCase("Tianjin")) {
            return "Tianjin";
        } else if (name.equalsIgnoreCase("Chongqing")) {
            return "Chongqing";
        }

        return null;
    }
}

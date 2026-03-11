package com.fishguard;

/**
 * WaterMetrics holds the vital signs of the fish pond.
 * Session 9 Upgrade: Added String parsing for Networking.
 */
public class WaterMetrics {
    private double temperature;
    private double phLevel;
    private double dissolvedOxygen;

    // Standard Constructor
    public WaterMetrics(double temperature, double phLevel, double dissolvedOxygen) {
        this.temperature = temperature;
        this.phLevel = phLevel;
        this.dissolvedOxygen = dissolvedOxygen;
    }

    /**
     * Networking Constructor: Parses a CSV string from a sensor.
     * Expects format: "temp,ph,oxygen"
     */
    public WaterMetrics(String rawData) {
        String[] parts = rawData.split(",");
        this.temperature = Double.parseDouble(parts[0]);
        this.phLevel = Double.parseDouble(parts[1]);
        this.dissolvedOxygen = Double.parseDouble(parts[2]);
    }

    public double getTemperature() { return temperature; }
    public double getPhLevel() { return phLevel; }
    public double getOxygen() { return dissolvedOxygen; }
}

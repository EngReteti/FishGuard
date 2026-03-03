package com.fishguard;

/**
 * WaterMetrics holds the vital signs of the fish pond.
 * This class acts as a data container for environmental readings.
 */
public class WaterMetrics {
    private double temperature;     // Temperature in Celsius
    private double phLevel;         // pH level (0.0 - 14.0)
    private double dissolvedOxygen; // Oxygen in mg/L

    // Constructor to initialize pond readings
    public WaterMetrics(double temperature, double phLevel, double dissolvedOxygen) {
        this.temperature = temperature;
        this.phLevel = phLevel;
        this.dissolvedOxygen = dissolvedOxygen;
    }

    // Getters for accessing private data
    public double getTemperature() { return temperature; }
    public double getPhLevel() { return phLevel; }
    public double getOxygen() { return dissolvedOxygen; }
}

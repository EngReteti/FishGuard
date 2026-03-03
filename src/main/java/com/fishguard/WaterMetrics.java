package com.fishguard;

public class WaterMetrics {
    private double temperature;
    private double phLevel;
    private double dissolvedOxygen;

    public WaterMetrics(double temperature, double phLevel, double dissolvedOxygen) {
        this.temperature = temperature;
        this.phLevel = phLevel;
        this.dissolvedOxygen = dissolvedOxygen;
    }

    public double getTemperature() { return temperature; }
    public double getPhLevel() { return phLevel; }
    public double getOxygen() { return dissolvedOxygen; }
}

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

    public String getHealthStatus() {
        if (phLevel < 6.5 || phLevel > 8.5) {
            return "DANGER: pH level is unstable!";
        }
        if (dissolvedOxygen < 5.0) {
            return "CRITICAL: Low Oxygen levels!";
        }
        return "SAFE: Water parameters are optimal.";
    }

    public double getTemperature() { return temperature; }
    public double getPhLevel() { return phLevel; }
    public double getOxygen() { return dissolvedOxygen; }
}

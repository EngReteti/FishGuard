package com.fishguard;

public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   FISHGUARD: SMART POND MONITOR    ");
        System.out.println("====================================");
        
        WaterMetrics currentReading = new WaterMetrics(27.0, 7.2, 6.5);
        
        System.out.println("Pond Stats:");
        System.out.println(" -> Temperature: " + currentReading.getTemperature() + "C");
        System.out.println(" -> pH Level:    " + currentReading.getPhLevel());
        System.out.println(" -> Oxygen:      " + currentReading.getOxygen() + " mg/L");
        System.out.println("\nCURRENT STATUS: " + currentReading.getHealthStatus());
        System.out.println("====================================");
    }
}

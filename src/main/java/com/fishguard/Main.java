package com.fishguard;

public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   FISHGUARD: SMART POND MONITOR    ");
        System.out.println("====================================");
        
        // Simulating a reading with LOW OXYGEN (4.2)
        WaterMetrics currentReading = new WaterMetrics(26.5, 7.1, 4.2);
        AlertSystem alertUnit = new AlertSystem();
        
        System.out.println("Pond Data -> Temp: " + currentReading.getTemperature() + "C | pH: " + currentReading.getPhLevel());
        
        // This is the core logic of Phase 2
        alertUnit.checkMetrics(currentReading);
        
        System.out.println("====================================");
    }
}

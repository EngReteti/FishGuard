package com.fishguard;

/**
 * AlertSystem handles the logic for notifying the farmer
 * when water conditions become dangerous.
 */
public class AlertSystem {

    /**
     * Checks metrics against safety thresholds and prints alerts if necessary.
     * @param metrics The current water readings to analyze
     */
    public void checkMetrics(WaterMetrics metrics) {
        System.out.println("\n[SYSTEM CHECKING FOR ALERTS...]");
        
        // Check for pH instability (Safe range: 6.5 - 8.5)
        if (metrics.getPhLevel() < 6.5 || metrics.getPhLevel() > 8.5) {
            printAlert("pH LEVEL CRITICAL", "Check water acidity immediately!");
        } 
        // Check for Low Oxygen (Critical if below 5.0 mg/L)
        else if (metrics.getOxygen() < 5.0) {
            printAlert("LOW OXYGEN", "Turn on the pond aerators now!");
        } 
        // If all parameters are within safe limits
        else {
            System.out.println("STATUS: All systems normal. Fish are happy.");
        }
    }

    /**
     * Formats and prints a professional alert box to the console.
     */
    private void printAlert(String title, String advice) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!! ALERT: " + title);
        System.out.println("!! ACTION: " + advice);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}

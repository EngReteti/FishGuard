package com.fishguard;

/**
 * AlertSystem handles the logic for notifying the farmer.
 * Session 6 Upgrade: Added basic exception prevention (Null Checks).
 */
public class AlertSystem {

    /**
     * Checks metrics against safety thresholds.
     * Includes a safety check to ensure metrics object is not null.
     */
    public void checkMetrics(WaterMetrics metrics) {
        // Defensive Programming: Check if the object exists before using it
        if (metrics == null) {
            System.out.println("[ERROR]: Cannot check metrics. Data reading is null.");
            return;
        }

        System.out.println("\n[SYSTEM CHECKING FOR ALERTS...]");
        
        if (metrics.getPhLevel() < 6.5 || metrics.getPhLevel() > 8.5) {
            printAlert("pH LEVEL CRITICAL", "Check water acidity immediately!");
        } else if (metrics.getOxygen() < 5.0) {
            printAlert("LOW OXYGEN", "Turn on the pond aerators now!");
        } else {
            System.out.println("STATUS: All systems normal. Fish are happy.");
        }
    }

    private void printAlert(String title, String advice) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!! ALERT: " + title);
        System.out.println("!! ACTION: " + advice);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}

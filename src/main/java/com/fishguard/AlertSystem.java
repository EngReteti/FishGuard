package com.fishguard;

public class AlertSystem {
    public void checkMetrics(WaterMetrics metrics) {
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

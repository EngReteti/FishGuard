package com.fishguard;

public class AlertSystem {
    private NotificationService notifier = new NotificationService();

    public void checkMetrics(WaterMetrics m) {
        // Critical Thresholds for Tilapia/Catfish
        if (m.getOxygen() < 4.0) {
            notifier.sendEmergencyAlert("CRITICAL: Oxygen dropped to " + m.getOxygen() + "mg/L. Aerators required!");
        }
        
        if (m.getPhLevel() < 6.0 || m.getPhLevel() > 8.5) {
            notifier.sendEmergencyAlert("WARNING: pH Level is " + m.getPhLevel() + ". Water quality unstable.");
        }
    }
}

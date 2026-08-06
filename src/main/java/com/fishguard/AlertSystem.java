package com.fishguard;

/**
 * AlertSystem: Production Fault Tolerance.
 * Session 26: Consecutive Failure Threshold & Recovery Alerts.
 */
public class AlertSystem {
    private NotificationService notifier = new NotificationService();
    private static int oxygenViolationCount = 0;
    private static final int THRESHOLD = 3;
    private static boolean isAlertActive = false;

    public void checkMetrics(WaterMetrics m) {
        // Evaluate Dissolved Oxygen
        if (m.getOxygen() < 4.0) {
            oxygenViolationCount++;
            System.out.println("[ALERT MONITOR]: Low O2 anomaly detected (" + oxygenViolationCount + "/" + THRESHOLD + ")");

            if (oxygenViolationCount >= THRESHOLD && !isAlertActive) {
                isAlertActive = true;
                notifier.sendEmergencyAlert("CRITICAL: Sustained low oxygen level (" 
                    + m.getOxygen() + " mg/L). Immediate aeration needed!");
            }
        } else {
            // Trigger recovery notification if oxygen returns to safe levels
            if (isAlertActive && m.getOxygen() >= 5.0) {
                notifier.sendEmergencyAlert("RECOVERY: Oxygen levels restored to safe range (" 
                    + m.getOxygen() + " mg/L).");
                isAlertActive = false;
            }
            oxygenViolationCount = 0;
        }
    }
}

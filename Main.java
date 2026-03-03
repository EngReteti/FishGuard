package com.fishguard;

public class Main {
	    public static void main(String[] args) {
	    	        System.out.println("====================================");
	    	                System.out.println("   FISHGUARD: SMART POND MONITOR    ");
	    	                        System.out.println("====================================");

	    	                                        // Simulating a DANGEROUS reading (Low Oxygen: 4.2)
	    	                                                WaterMetrics currentReading = new WaterMetrics(27.0, 7.2, 4.2);
	    	                                                        AlertSystem alerts = new AlertSystem();

	    	                                                                        System.out.println("Current Reading: Oxygen at " + currentReading.getOxygen() + " mg/L");

	    	                                                                                        // Let the alert system decide what to do
	    	                                                                                                alerts.checkMetrics(currentReading);

	    	                                                                                                                System.out.println("====================================");
	    	                                                                                                                    }
	    	                                                                                                                    }
	    	                                                                                                                    
	   }

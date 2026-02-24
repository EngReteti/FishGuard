package com.fishguard;

/**
 * WaterMetrics holds the vital signs of the fish pond.
  * This helps farmers understand if the environment is safe for fish.
   */
   public class WaterMetrics {
   	    private double temperature; 
   	        private double phLevel;     
   	            private double dissolvedOxygen; 

   	                // Constructor: Initialize the data
   	                    public WaterMetrics(double temperature, double phLevel, double dissolvedOxygen) {
   	                    	        this.temperature = temperature;
   	                    	                this.phLevel = phLevel;
   	                    	                        this.dissolvedOxygen = dissolvedOxygen;
   	                    	                            }

   	                    	                                // This method validates if the water is safe for fish
   	                    	                                    public String getHealthStatus() {
   	                    	                                    	        if (phLevel < 6.5 || phLevel > 8.5) {
   	                    	                                    	        	            return "DANGER: pH level is unstable!";
   	                    	                                    	        	                    }
   	                    	                                    	        	                            if (dissolvedOxygen < 5.0) {
   	                    	                                    	        	                            	            return "CRITICAL: Low Oxygen levels detected!";
   	                    	                                    	        	                            	                    }
   	                    	                                    	        	                            	                            return "SAFE: Water parameters are optimal.";
   	                    	                                    	        	                            	                                }

   	                    	                                    	        	                            	                                    // Getters
   	                    	                                    	        	                            	                                        public double getTemperature() { return temperature; }
   	                    	                                    	        	                            	                                            public double getPhLevel() { return phLevel; }
   	                    	                                    	        	                            	                                                public double getDissolvedOxygen() { return dissolvedOxygen; }
   	                    	                                    	        	                            	                                                }
   	                    	                                    	        	                            	                                                
   	                    	                                    	        	                        
   	                    	                                    	      
   	                    	                                 
   	                  
 

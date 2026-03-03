package com.fishguard;

/**
 * AlertSystem handles the logic for notifying the farmer
  * when water conditions become dangerous.
   */
   public class AlertSystem {

   	    public void checkMetrics(WaterMetrics metrics) {
   	    	        System.out.println("\n[SYSTEM CHECKING FOR ALERTS...]");

   	    	                        if (metrics.getPhLevel() < 6.5 || metrics.getPhLevel() > 8.5) {
   	    	                        	            sendAlert("pH LEVEL CRITICAL", "Immediate water treatment required.");
   	    	                        	                    } else if (metrics.getOxygen() < 5.0) {
   	    	                        	                    	            sendAlert("LOW OXYGEN", "Turn on aerators immediately!");
   	    	                        	                    	                    } else {
   	    	                        	                    	                    	            System.out.println("Status: No active threats detected.");
   	    	                        	                    	                    	                    }
   	    	                        	                    	                    	                        }

   	    	                        	                    	                    	                            private void sendAlert(String type, String action) {
   	    	                        	                    	                    	                            	        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
   	    	                        	                    	                    	                            	                System.out.println("ALERT: " + type);
   	    	                        	                    	                    	                            	                        System.out.println("ACTION: " + action);
   	    	                        	                    	                    	                            	                                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
   	    	                        	                    	                    	                            	                                    }
   	    	                        	                    	                    	                            	                                    }
   	    	                        	                    	                    	                            	                                    
   	    	                        	                    	                    	                           
   	    	                        	                    	                    }
   	    	                        	                    }
   	    	                        }
   	    }
   }

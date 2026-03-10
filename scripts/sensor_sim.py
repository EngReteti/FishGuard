import random
import time

"""
FishGuard Mock Sensor Simulator (Session 8)
This script simulates a real hardware sensor sending water metrics.
"""

def generate_metrics():
    # Simulating realistic pond values
    temp = round(random.uniform(24.0, 30.0), 1)
    ph = round(random.uniform(6.0, 9.0), 1)
    oxygen = round(random.uniform(3.0, 8.0), 1)
    
    return f"{temp},{ph},{oxygen}"

if __name__ == "__main__":
    print("--- FishGuard Sensor Simulation Started ---")
    # Generating a test reading
    reading = generate_metrics()
    print(f"Generated Reading: {reading}")

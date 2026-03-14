import socket
import time
import random

def generate_metrics():
    temp = round(random.uniform(24.0, 30.0), 1)
    ph = round(random.uniform(6.0, 9.0), 1)
    oxygen = round(random.uniform(3.0, 8.0), 1)
    return f"{temp},{ph},{oxygen}"

def start_sensor():
    host = '127.0.0.1'
    port = 5000
    print("--- FishGuard Sensor Started (Press Ctrl+C to stop) ---")

    while True:
        data = generate_metrics()
        try:
            with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
                s.connect((host, port))
                s.sendall(data.encode())
                print(f"[SENSOR]: Sent -> {data}")
        except ConnectionRefusedError:
            print("[WAITING]: Java server not ready. Retrying...")
        
        time.sleep(5) # Wait 5 seconds before next reading

if __name__ == "__main__":
    start_sensor()

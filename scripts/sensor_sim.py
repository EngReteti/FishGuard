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
    print("--- FishGuard Sensor Started ---")

    while True:
        data = generate_metrics()
        try:
            with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
                s.connect((host, port))
                s.sendall(data.encode() + b'\n')
                
                # Wait for the confirmation from Java
                response = s.recv(1024).decode()
                print(f"[SENSOR]: Sent {data} | Server Response: {response}")
        except ConnectionRefusedError:
            print("[WAITING]: Java server not ready...")
        
        time.sleep(5)

if __name__ == "__main__":
    start_sensor()

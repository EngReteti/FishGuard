import socket
import time

def send_test_reading():
    # Configuration
    host = '127.0.0.1'
    port = 5000
    data = "26.5,7.2,4.2" # Simulated Temp, pH, Oxygen

    try:
        # Create a socket and connect to Java
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
            print(f"[SENSOR]: Connecting to Java server at {host}:{port}...")
            s.connect((host, port))
            s.sendall(data.encode())
            print(f"[SENSOR]: Data sent successfully: {data}")
    except ConnectionRefusedError:
        print("[ERROR]: Java server is not running!")

if __name__ == "__main__":
    send_test_reading()

# FishGuard: IoT Water Monitoring System

FishGuard is a multi-threaded backend system designed for real-time monitoring of fish pond vitals (Temperature, pH, and Dissolved Oxygen).

## 🚀 Phase 4: Database & Networking (96% Complete)
The system has transitioned from local file logging to a **Distributed Architecture**:
- **Sensor Layer**: Python scripts simulating real-time IoT sensors with encryption keys.
- **Network Layer**: Java ServerSocket handling concurrent connections via Multithreading.
- **Persistence Layer**: SQLite Database integration using JDBC for relational data storage.

## 📂 Project Structure
- `src/main/java/com/fishguard/`: Core Java Backend (Logic, Networking, DB).
- `scripts/`: Python sensor simulators.
- `libs/`: External dependencies (SQLite JDBC Driver).
- `config.properties`: Environment-specific settings.
- `fishguard.db`: SQLite database file (auto-generated).

## 🛠️ How to Run
1. **Start the Java Server**:
   ```bash
   javac -cp "libs/*:src/main/java" src/main/java/com/fishguard/*.java
   java -cp "libs/*:src/main/java" com.fishguard.Main
   ```
2. **Start the Sensor**:
   ```bash
   python scripts/sensor_sim.py
   ```

## 🛡️ Security
Connections are verified via a dynamic `auth.key` defined in the configuration layer.

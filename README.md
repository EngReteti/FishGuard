# 🐟 FishGuard: Distributed IoT Monitoring System

FishGuard is a robust, multi-threaded backend engineered in Java to monitor aquaculture environments. It features a cross-language data pipeline (Python to Java) and secure relational persistence.

## 🏗️ System Architecture
- **Perception Layer (Python)**: High-fidelity sensor simulation with synchronized TCP transmission.
- **Transport Layer (Java Sockets)**: A multi-threaded server utilizing a custom "Handshake" protocol for data integrity.
- **Persistence Layer (SQLite/JDBC)**: Secure data storage using PreparedStatements to ensure ACID compliance.
- **Security**: Environment-decoupled authentication via `config.properties`.

## 📂 Repository Blueprint
- `src/`: Modular Java source code (DAO, Networking, Logic).
- `scripts/`: Python simulators for remote sensors.
- `libs/`: Binary dependencies (SQLite JDBC Driver).
- `docs/`: SQL Schemas and architectural diagrams.
- `config.properties`: Externalized system configurations.

## 🚀 Execution Guide
1. **Initialize the Server**:
   ```bash
   javac -cp "libs/*:src/main/java" src/main/java/com/fishguard/*.java
   java -cp "libs/*:src/main/java" com.fishguard.Main
   ```
2. **Deploy Sensors**:
   ```bash
   python scripts/sensor_sim.py
   ```

---
*Developed with a logic-first approach to distributed systems mastery.*

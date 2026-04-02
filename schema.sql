-- FishGuard Database Schema
-- Version: 1.0 (Session 18)

CREATE DATABASE IF NOT EXISTS fishguard_db;
USE fishguard_db;

CREATE TABLE IF NOT EXISTS pond_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    temperature DOUBLE NOT NULL,
    ph_level DOUBLE NOT NULL,
    oxygen_level DOUBLE NOT NULL,
    status VARCHAR(50)
);

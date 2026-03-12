# Space Exploration System

A comprehensive Java application for managing and analyzing space mission data, including manned and unmanned missions, astronaut information, and mission success statistics.

## Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [Classes Overview](#classes-overview)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Usage](#usage)
- [Data Format](#data-format)
- [Sample Data](#sample-data)
- [Author](#author)

## Features

- **View All Missions**: Display complete mission data from CSV files
- **Manned Missions**: Filter and display only manned space missions with astronaut details
- **Unmanned Missions**: Filter and display robotic/probe missions
- **Astronaut Management**: View astronauts assigned to specific missions
- **Add New Missions**: Create and add new mission records (manned or unmanned)
- **Edit Existing Missions**: Modify mission details including astronaut assignments
- **Mission Statistics**: Calculate and display success rate summaries (average, highest, lowest)
- **Nationality Search**: Find all astronauts from a specific country/nationality
- **CSV Data Persistence**: Read from and write to CSV files for data storage

## Project Structure

```
PDI_Assignment_22871631_BhagwatPatel/
├── Astronaut.java              # Astronaut class definition
├── Mission.java                # Mission class definition
├── MissionController.java      # Data processing and file I/O operations
├── SpaceExplorationSystem.java # Main application with user interface
├── SpaceExplorationSystemPseudocode.txt # Pseudocode documentation
├── data.csv                    # Sample mission data file
├── .gitignore                  # Git ignore file
└── README.md                   # This file
```

## Classes Overview

### Astronaut Class
- **Purpose**: Represents individual astronauts with their details
- **Fields**: name, role, age, nationality
- **Methods**: Getters/setters, toString(), toCSV() for data serialization

### Mission Class
- **Purpose**: Represents space missions with all relevant information
- **Fields**: name, code, destination planet, launch year, success rate, manned status, astronaut array
- **Methods**: Getters/setters, constructors, toString(), toCSV() for data operations

### MissionController Class
- **Purpose**: Handles all data processing, file I/O, and business logic
- **Key Methods**:
  - `storeInArray()`: Reads CSV data into Mission objects
  - `readFile()`: Displays raw file contents
  - `mannedMissions()` / `unmannedMissions()`: Filters missions by type
  - `findAstronauts()`: Searches for mission astronauts
  - `addMissiondetails()`: Appends new missions to CSV
  - `editMission()`: Updates existing mission data
  - `missionSummary()`: Calculates success rate statistics
  - `findNationality()`: Searches astronauts by nationality

### SpaceExplorationSystem Class
- **Purpose**: Main application class with user interface menu
- **Features**: Interactive menu system, user input handling, method orchestration

## Prerequisites

- **Java Development Kit (JDK)**: Version 21 or higher
- **Operating System**: Windows, macOS, or Linux
- **Memory**: Minimal requirements (handles up to 100 missions)

## Installation & Setup

1. **Clone or Download**: Ensure all Java files are in the same directory

2. **Compile the Application**:
   ```bash
   javac Astronaut.java Mission.java MissionController.java SpaceExplorationSystem.java
   ```

3. **Run the Application**:
   ```bash
   java SpaceExplorationSystem
   ```

## Usage

The application presents an interactive menu with the following options:

1. **View all missions** - Display complete mission data from CSV
2. **View all manned missions** - Show only crewed missions with astronaut details
3. **View all unmanned missions** - Show only robotic/probe missions
4. **View a mission's astronauts** - Search for astronauts on specific missions
5. **Add a new mission** - Create and save new mission records
6. **Edit an existing mission** - Modify existing mission information
7. **Summary of missions' success rates** - Display statistics (average, highest, lowest)
8. **List astronauts for a given nationality** - Search astronauts by country
9. **Exit** - Close the application

### Data File Selection
For operations requiring data access, you'll be prompted to specify a CSV file path (e.g., `data.csv`).

## Data Format

The application uses CSV (Comma-Separated Values) format for data persistence:

### Mission Record Format:
```
MissionName,MissionCode,DestinationPlanet,LaunchYear,SuccessRate,IsManned,AstronautData
```

### Astronaut Data Format (for manned missions):
```
AstronautName:Role:Age:Nationality|AstronautName:Role:Age:Nationality
```

### Field Descriptions:
- **MissionName**: String (e.g., "Apollo 11")
- **MissionCode**: String (e.g., "A11")
- **DestinationPlanet**: String (e.g., "Moon")
- **LaunchYear**: Integer (1900-2100)
- **SuccessRate**: Double (0.0-100.0)
- **IsManned**: Boolean (true/false)
- **AstronautData**: Pipe-separated astronaut records (empty for unmanned missions)

## Sample Data

The included `data.csv` file contains sample mission data including both manned and unmanned missions with astronaut information where applicable.

Example entries:
- Apollo 11 (manned, Moon, 1969, 100% success)
- Mars Rover (unmanned, Mars, 2021, 95% success)
- International Space Station missions with multiple astronauts

## Author

**Bhagwat Patel**
- Student ID: 22871631
- Course: PDI (Programming for Data Informatics)
- Date: April-May 2025

This project was developed as part of a university assignment demonstrating object-oriented programming principles, file I/O operations, and data management in Java.</content>
<parameter name="filePath">c:\Users\bhagw\OneDrive\Documents\University\PDI\PDI_Assignment_22871631_BhagwatPatel\README.md
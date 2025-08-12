# Mobile Automation Testing Project

This project demonstrates mobile automation testing using Java, Maven, and Appium for both Android and iOS platforms.

## Features

- Automated login test for a mobile application
- Supports both Android and iOS devices/emulators
- Uses Appium and Selenium WebDriver

## Prerequisites

- Java 11 or higher
- Maven 3.x
- Appium server
- Android/iOS emulator or real device
- Properly configured Appium drivers

## Project Structure

- `src/main/java/anh_edu/Main.java`: Main entry point for running tests
- `driver/DriverFactory.java`: Provides Appium driver instances

## How to Run

1. Start the Appium server.
2. Configure your device/emulator.
3. Build the project:
   ```sh
   mvn clean install
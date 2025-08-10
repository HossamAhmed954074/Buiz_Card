# 📱 Business Card App - Android Jetpack Compose

A modern, animated business card application built with **Jetpack Compose** that showcases professional information with smooth animations and a polished UI design.

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)

## 📸 Screenshots

*Add your app screenshots here*

## ✨ Features

- **Modern UI Design**: Clean, professional interface with Material Design 3
- **Smooth Animations**:
    - Profile image rotation animation
    - Portfolio section fade-in/fade-out
    - Button scaling effects
    - Contact section animations
- **Responsive Layout**: Optimized for different screen sizes
- **Professional Portfolio Display**: Showcases real projects with tech stacks
- **Contact Information**: Easy access to email, phone, and GitHub
- **Gradient Background**: Beautiful visual appeal with shadow effects

## 🛠️ Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM Pattern
- **Animation**: Compose Animation APIs
- **Design**: Material Design 3
- **Build System**: Gradle

## 🎯 Key Compose Components Used

- `AnimatedVisibility` - For smooth show/hide transitions
- `animateFloatAsState` - For continuous animations
- `LazyColumn` - For efficient portfolio list rendering
- `Card` with elevation and shadows
- `Gradient backgrounds` for visual appeal
- `Material3 theming` throughout the app

## 📋 Project Structure
app/ ├── src/main/java/com/demo/buiz_card/ │ ├── MainActivity.kt # Main activity with Compose setup │ ├── ui/theme/ # App theming │ └── res/ │ ├── drawable/ # Profile images and icons │ └── values/ # Colors, strings, themes

## 🚀 Getting Started

### Prerequisites

- Android Studio Narwhal Feature Drop | 2025.1.2 or later
- Android SDK 34+
- Kotlin 1.9.0+

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/HossamAhmed954074/buiz_card.git

Open in Android Studio


Open Android Studio
Select "Open an existing project"
Navigate to the cloned repository
Sync the project


Let Gradle sync all dependencies
Build the project
Run the application


Connect your Android device or start an emulator
Click "Run" or press Shift + F10
💼 Professional Information Displayed
Name: Hossam Ahmed
Title: Mobile Developer (Flutter & Android)
Location: Cairo, Egypt
Technologies: Flutter, Jetpack Compose, Firebase
Portfolio Projects:
Restaurant APP
Quiz Minds APP
Bus Booking App (Loopi)
Portfolio Web APP
Book Store App
🎨 Design Features
Animations
Profile Image: Rotates 360° when portfolio is toggled
Portfolio Content: Fade-in/scale-in animation
Button: Scaling effect on interaction
Contact Section: Smooth fade transitions
Visual Elements
Gradient Background: Purple-to-blue gradient
Card Elevation: Subtle shadows for depth
Rounded Corners: Modern 24dp radius
Color Scheme: Professional blue (#667eea) accent color
📱 Responsive Design
The app is designed to work seamlessly across different Android screen sizes:


Phone: Optimized layout for mobile devices
Tablet: Responsive design adapts to larger screens
Different densities: Proper dp/sp units for consistent appearance
🔧 Customization
Updating Personal Information
To customize the app with your information, edit these sections in MainActivity.kt:

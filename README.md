# Intent Activity Demo


This project is a simple Android application that demonstrates the use of explicit and implicit intents to navigate between different activities and send data across them. The application includes four main activities:

- **MainActivity**: The starting point, which initiates the navigation and data sending to other activities.
- **BActivity**: Receives and sends data back to `MainActivity` or forwards it to `CActivity`.
- **CActivity**: Receives data from `BActivity`.
- **MyImplicitIntent**: Demonstrates implicit intents, such as opening a browser or sending an SMS.

## Table of Contents

- [Getting Started](#getting-started)
- [Structure](#structure)
- [Usage](#usage)
- [Screenshots](#screenshots)
- [How Intents Work](#how-intents-work)
- [License](#license)

---

## Getting Started

To get a local copy of this project up and running, follow these simple steps:

### Prerequisites

- **Android Studio**: Download and install [Android Studio](https://developer.android.com/studio).
- **Android Device or Emulator**: The application can be run on a physical Android device or an emulator.

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/IRedDragonICY/cb24153-lab-intent-activity.git
   ```
2. **Open in Android Studio**:
   Open Android Studio, navigate to `File -> Open`, and select the cloned project.
3. **Build and Run**:
   After the project loads, click on the `Run` button or use `Shift + F10` to build and deploy the app on an emulator or connected device.

---

## Structure

The project is structured as follows:

- **MainActivity.kt**: The main activity that sends data to `BActivity`, `CActivity`, and triggers the implicit intent to open `MyImplicitIntent`.
- **BActivity.java**: An activity that receives data from `MainActivity`, displays it, and allows sending data back to `MainActivity` or forwarding it to `CActivity`.
- **CActivity.java**: Receives data from `BActivity` and displays it.
- **MyImplicitIntent.java**: Demonstrates implicit intents, allowing the user to open a URL in a browser or send an SMS.
- **XML Layout Files**:
  - `mainactivity.xml`: Layout for `MainActivity`【15†source】.
  - `bactivity.xml`: Layout for `BActivity`【13†source】.
  - `cactivity.xml`: Layout for `CActivity`【14†source】.
  - `myimplicitintentactivity.xml`: Layout for `MyImplicitIntent`【16†source】.

---

## Usage

1. **Main Activity**:
   - Input data in the "Set Info." field.
   - Choose one of the options:
     - **Send To B**: Sends data to `BActivity`.
     - **Send To C**: Sends data directly to `CActivity`.
     - **Imp. Act.**: Opens `MyImplicitIntent` for implicit intents.

2. **B Activity**:
   - Displays the received data from `MainActivity`.
   - Allows sending data back to `MainActivity` with **Reply Main** or forwarding it to `CActivity` with **Send To C**.

3. **C Activity**:
   - Displays data received from either `MainActivity` or `BActivity`.

4. **My Implicit Intent**:
   - Provides options to perform implicit actions, such as opening a browser or sending an SMS.


---

## How Intents Work

Intents are used to navigate between different activities and pass data in Android. This application demonstrates both **Explicit Intents** (for navigating to a specified activity) and **Implicit Intents** (for actions like opening a URL in a browser).

### Intent Workflow
![Intent Workflow](https://github.com/user-attachments/assets/7dffee14-f36b-423a-a513-32f51c8c63f3)

# Intent Application

1. **Explicit Intents**:
   - **MainActivity** to **BActivity** and **CActivity**:
     - Data is sent using `Intent.putExtra("key", value)` and received using `getIntent().getStringExtra("key")`.
   
   - **BActivity** back to **MainActivity**:
     - Data is sent back using `setResult()` and received in `MainActivity` through `onActivityResult()`.

2. **Implicit Intents**:
   - **MyImplicitIntent** activity allows for implicit actions like browsing a website or sending an SMS.

---

## Demo

[![Watch the demo](https://img.youtube.com/vi/OZVv5iGewpc/0.jpg)](https://youtu.be/OZVv5iGewpc)


---

## License

This project is licensed under the GNU General Public License v3.0. For more information, see the [LICENSE](LICENSE) file.

---

## Additional Notes

- This application serves as a demonstration for Android Intents.
- Make sure to handle permissions, especially for actions like sending SMS, in a real-world application.
- The layouts and activities can be customized as per your project's requirements.

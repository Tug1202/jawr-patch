# Just Another Witchery Mod_PATCH

A small community patch mod for **Just Another Witchery Remake** for Minecraft 1.21.1.

This mod exists to fix bugs, restore missing functionality, and make small gameplay corrections without modifying the original Witchery mod files.

**This is an unofficial community-made patch. It is a separate mod and is not affiliated with, endorsed by, or an official project of the developers of Just Another Witchery Remake.**

## 📥 Download

**[⬇️ Download the Latest Release](../../releases/latest)**

Download the `.jar` file from the **Assets** section of the latest GitHub release.

> **Do not download the source code unless you are interested in developing or modifying the patch.**

## ✨ Current Fixes

### 🌱 Glintweed & Ember Moss propagation

Adds natural random-tick propagation to:

* `witchery:glintweed`
* `witchery:ember_moss`

These plants can now spread horizontally to nearby valid locations through normal Minecraft random ticks.

The original Witchery mod files are not modified.

### 🧺 Soul Cage loot fix

Fixes the Soul Cage loot table so that breaking a Soul Cage correctly produces the intended **Witchery Brazier** drop.

## 🔧 Planned / Future Fixes

This project may eventually contain additional patches for Just Another Witchery Remake and related functionality.

Potential future fixes include:

* Additional broken or missing Witchery functionality
* Mutandis plant-selection behavior
* Other small gameplay or compatibility fixes discovered during testing

This list is subject to change as additional issues are investigated.

## 📦 Installation

1. Install **Minecraft 1.21.1** with the required NeoForge version.
2. Install **Just Another Witchery Remake** and any other required Witchery addons.
3. Download the latest `jawr_patch-*.jar` from the [Releases](../../releases) page.
4. Place the `.jar` file into your Minecraft `mods` folder.
5. Launch Minecraft.

## 🛠️ For Developers

This repository contains the source code used to build the patch mod.

### Requirements

* Minecraft 1.21.1
* NeoForge
* Java 21
* IntelliJ IDEA or another Java IDE
* NeoGradle

### Building

Clone the repository and run:

```powershell
.\gradlew build
```

The resulting mod JAR will be located in:

```text
build/libs/
```

## 🎯 Project Philosophy

This project is intended to be a lightweight patch layer for Just Another Witchery Remake.

The goal is to:

* Fix specific bugs or missing functionality.
* Avoid modifying the original Witchery JARs.
* Avoid unnecessarily changing global Minecraft or modpack behavior.
* Keep patches as isolated and understandable as possible.
* Make the resulting fixes easy for players to install.

## 📜 License

This project is licensed under the **GNU General Public License v3.0 or later**.

See [LICENSE](LICENSE) for the full license terms.

## ❤️ Credits

Created by **Tug1202**.

Built for the Minecraft 1.21.1 modding ecosystem and intended for use alongside Just Another Witchery Remake.

### Disclaimer

**Just Another Witchery Mod_PATCH is an unofficial, community-made patch. It is not affiliated with, endorsed by, or an official project of the developers of Just Another Witchery Remake.**

The original Witchery project and its developers retain their respective names, trademarks, copyrights, and other rights. This project does not claim ownership of the original Witchery mod or its assets.

# react-native-kotlin-camera-module

## Getting started

`$ npm install react-native-kotlin-camera-module --save`

### Mostly automatic installation

`$ react-native link react-native-kotlin-camera-module`

### Manual installation

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-kotlin-camera-module` and add `KotlinCameraModule.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libKotlinCameraModule.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`

- Add `import com.reactlibrary.KotlinCameraModulePackage;` to the imports at the top of the file
- Add `new KotlinCameraModulePackage()` to the list returned by the `getPackages()` method

2. Append the following lines to `android/settings.gradle`:
   ```
   include ':react-native-kotlin-camera-module'
   project(':react-native-kotlin-camera-module').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-kotlin-camera-module/android')
   ```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
   ```
     compile project(':react-native-kotlin-camera-module')
   ```

## Usage

```javascript
import KotlinCameraModule from "react-native-kotlin-camera-module";

// TODO: What to do with the module?
KotlinCameraModule;
```

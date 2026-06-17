# Building

## Prerequisites

- Android Studio or a local Android build toolchain
- JDK 11
- Shizuku for runtime testing on a device

## Commands

```powershell
.\gradlew.bat :app:assembleDebug
.\gradlew.bat :app:lintDebug
.\gradlew.bat :app:testDebugUnitTest
```

To build a signed release, copy `release-signing.properties.example` to
`release-signing.properties`, fill in the local signing credentials, then run:

```powershell
.\gradlew.bat :app:assembleRelease
```

## Outputs

- Debug APK: `app/build/outputs/apk/debug/app-debug.apk`
- Unsigned release APK, when signing credentials are not configured:
  `app/build/outputs/apk/release/app-release-unsigned.apk`
- Signed release APK, when signing credentials are configured:
  `app/build/outputs/apk/release/app-release.apk`

## Notes

- The project currently targets Android 12+.
- Release signing uses the ignored local `release-signing.properties` file or
  `HIKARI_SIGNING_*` environment variables.
- Keep `hikari-release.jks` and signing credentials out of git.

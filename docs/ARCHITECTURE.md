# Architecture

Hikari is organized around a small set of Android components:

- `HikariApplication` applies dynamic colors to activities.
- `MainActivity` handles the main dashboard, payload preview, manual upload, and sync controls.
- `SettingsActivity` manages server settings, Shizuku authorization, and foreground app filters.
- `AppPickerActivity` reads installed apps in the background and lets the user select filter packages.
- `StatusSyncService` runs the long-lived foreground sync loop.
- `StatusWorker` handles one-time uploads.
- `StatusUploader` sends JSON payloads to the configured API.
- `DeviceStatusCollector` reads device state through Shizuku.
- `AppSettings` stores local preferences.
- `ShizukuShell` executes shell commands through the Shizuku service.

## Sync Flow

1. The user starts automatic sync from the main screen.
2. The app requests notification permission when needed.
3. The foreground service starts and acquires a wake lock.
4. Status is collected and uploaded on a fixed interval.
5. The user can stop sync from the notification or the main screen.

## Source Layout

```text
app/src/main/java/cafe/miafetta/hikari/
```

Android resources live under `app/src/main/res/`.

Local test source directories are omitted until the project has active automated
tests.

# Usage

## Requirements

- Android 12 or later
- Shizuku installed and running
- A server endpoint that accepts JSON uploads

## Configure the App

1. Open Hikari.
2. Grant Shizuku authorization.
3. Open settings.
4. Enter the server API URL.
5. Optionally enter a Bearer upload token.
6. Configure upload interval, display delay, private mode, and foreground app filters.

When adding foreground filter packages, Hikari reads the installed app list in
the background and shows a loading dialog until the list is ready.

## Upload Payload

Hikari uploads these JSON fields:

```json
{
  "model": "device model",
  "battery_raw": "raw battery status",
  "wifi_raw": "Wi-Fi status",
  "net_raw": "cellular network type",
  "location_raw": "last location output",
  "current_app_package": "current foreground app package",
  "current_app_name": "current foreground app name"
}
```

When private mode is enabled, these fields are uploaded as:

```text
none
```

## Server API

Hikari sends a `POST` request with a JSON body:

```http
POST /api/upload_raw
Content-Type: application/json
Authorization: Bearer <upload-token>
```

The upload token is optional. If it is empty, Hikari does not attach the `Authorization` header.

## Automatic Sync

Automatic sync runs as a foreground service. After tapping "Start automatic sync", Hikari shows a foreground notification and uploads status at the configured interval.

Sync can be stopped from the notification or from the main screen.

To reduce background restrictions, Hikari applies best-effort Shizuku commands such as:

```text
cmd deviceidle whitelist +cafe.miafetta.hikari
dumpsys deviceidle whitelist +cafe.miafetta.hikari
cmd appops set cafe.miafetta.hikari RUN_ANY_IN_BACKGROUND allow
cmd appops set cafe.miafetta.hikari RUN_IN_BACKGROUND allow
cmd appops set cafe.miafetta.hikari START_FOREGROUND allow
cmd appops set cafe.miafetta.hikari WAKE_LOCK allow
```

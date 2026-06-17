# Releases

Hikari uses two APK artifacts in the release workflow:

- a versioned APK for the tagged release, named `hikari-android-v<version>.apk`
- a rolling `app-release.apk` for the latest build

## Release Checklist

1. Bump `versionCode` and `versionName` in `app/build.gradle.kts`.
2. Build and verify the app locally.
3. Sign the release APK.
4. Publish `hikari-android-v<version>.apk` and the rolling `app-release.apk` together.
5. Update the changelog and README files if user-facing behavior changed.

## Notes

- Keep release notes short and factual.
- Match the published binary name to the documented version.
- Verify the signed APK before uploading release assets.

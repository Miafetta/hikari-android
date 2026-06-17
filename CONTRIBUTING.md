# Contributing

Thanks for your interest in Hikari.

## Before You Start

- Reproduce the issue or feature request locally if possible.
- Keep changes focused.
- Update both README files when user-facing behavior changes.

## Local Checks

```powershell
.\gradlew.bat :app:assembleDebug
.\gradlew.bat :app:lintDebug
.\gradlew.bat :app:testDebugUnitTest
```

## Pull Requests

- Describe what changed and why.
- Mention any behavior changes or migration notes.
- Include screenshots or logs when they help review.

## Style

- Follow the existing Kotlin and Android resource style.
- Prefer small, targeted edits over broad refactors.

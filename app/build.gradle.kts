import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
}

val releaseSigningPropertiesFile = rootProject.file("release-signing.properties")
val releaseSigningProperties = Properties().apply {
    if (releaseSigningPropertiesFile.isFile) {
        releaseSigningPropertiesFile.inputStream().use(::load)
    }
}

fun releaseSigningValue(name: String): String? {
    val envName = "HIKARI_SIGNING_" + name
        .replace(Regex("([a-z])([A-Z])"), "$1_$2")
        .uppercase()
    return releaseSigningProperties.getProperty(name)
        ?: providers.gradleProperty("hikari.signing.$name").orNull
        ?: providers.environmentVariable(envName).orNull
}

val releaseStoreFile = releaseSigningValue("storeFile")?.let(rootProject::file)
val hasReleaseSigning = releaseStoreFile?.isFile == true &&
    releaseSigningValue("storePassword") != null &&
    releaseSigningValue("keyAlias") != null &&
    releaseSigningValue("keyPassword") != null

android {
    namespace = "cafe.miafetta.hikari"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "cafe.miafetta.hikari"
        minSdk = 31
        targetSdk = 36
        versionCode = 6
        versionName = "2.0"

        ndk {
            abiFilters += listOf("arm64-v8a")
        }
    }

    signingConfigs {
        if (hasReleaseSigning) {
            create("release") {
                storeFile = releaseStoreFile
                storePassword = releaseSigningValue("storePassword")
                keyAlias = releaseSigningValue("keyAlias")
                keyPassword = releaseSigningValue("keyPassword")
            }
        }
    }

    buildTypes {
        release {
            if (hasReleaseSigning) {
                signingConfig = signingConfigs.getByName("release")
            }
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    implementation(libs.shizuku.api)
    implementation(libs.shizuku.provider)
    implementation(libs.okhttp)
    implementation(libs.androidx.work.runtime.ktx)
}

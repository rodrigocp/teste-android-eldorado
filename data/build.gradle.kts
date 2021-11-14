plugins {
    id("com.android.library")
    kotlin("kapt")
    kotlin("android")
}

android {
    compileSdk = Configuration.compileSDKVersion

    defaultConfig {
        minSdk                    = Configuration.minSDKVersion
        targetSdk                 = Configuration.targetSDKVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled =  false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility            = JavaVersion.VERSION_1_8
        targetCompatibility            = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    implementation(project(":domain"))
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
    kapt(Dependencies.roomcompiler)
    implementation(Dependencies.roomktx)
    implementation(Dependencies.roomruntime)
    implementation(Dependencies.roomtesting)
    implementation(Dependencies.koin)
    implementation(Dependencies.corektx)
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.junitext)
    testImplementation(Dependencies.expresso)
}
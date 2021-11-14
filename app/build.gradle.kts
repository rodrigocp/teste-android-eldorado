import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("kapt")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Configuration.compileSDKVersion)

    defaultConfig {
        applicationId             = "br.com.rcp.todolist"
        minSdk                    = Configuration.minSDKVersion
        targetSdk                 = Configuration.targetSDKVersion
        versionCode               = 1
        versionName               = "1.0"
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

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
    implementation(Dependencies.corektx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.koin)
    implementation(Dependencies.constraintlayout)
    implementation(Dependencies.navigationfragment)
    implementation(Dependencies.navigationui)
    implementation(Dependencies.lifecyclelivedata)
    implementation(Dependencies.lifecycleruntime)
    implementation(Dependencies.lifecycleviewmodel)
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.junitext)
    testImplementation(Dependencies.expresso)
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply{
        set("kotlinVersion", "1.5.31")
    }

    val kotlin_version = extra.get("kotlinVersion") as String

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath (Plugins.gradle)
        classpath (Plugins.kotlin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}
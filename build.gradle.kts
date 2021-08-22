buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    val sql_delight_version = "1.5.1"
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.android.tools.build:gradle:7.0.1")
        classpath("com.squareup.sqldelight:gradle-plugin:$sql_delight_version")
        classpath("com.google.gms:google-services:4.3.10")
        classpath(kotlin("serialization", version = "1.5.21"))
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
ext {
    val coroutine_version = "1.3.2"
    val serializer_version = "0.13.0"
    val ktor_version = "1.2.5"
    val react_version = "16.9.0"
    val compose_version = "1.0.1"

    val sqldelight_version = "1.2.0"

    val support_library_version = "28.1.1"
    val constraint_layout_version = "1.1.0"
    val espresso_version = "3.0.1"
    val retrofit_version = "2.4.0"
    val okhttp_version = "4.0.1"
    val kotlin_coroutines_version = "1.2.1"
    val mockito_version = "2.18.3"

    val anko_version = "0.10.4"
    val buildToolsVersion = "27.0.3"
    val playServicesLocationVersion = "16.0.0"
    val playServicesAuthVersion = "15.0.1"
    val playServicesVisionVersion = "15.0.2"

    val firebaseAuthVersion = "16.0.2"
    val firebaseCoreVersion = "16.0.1"
    val firebaseMessagingVersion = "17.1.0"
    val firebaseFireStoreVersion = "17.3.0"
    val firebaseDatabaseVersion = "16.0.1"

    val retrofitVersion = "2.3.0"
    val butterknifeVersion = "10.1.0"
    val daggerVersion = "2.22.1"
    val picassoVersion = "2.71828"
    val roomVersion = "2.0.0-beta01"
    val gsonVersion = "2.8.5"
    val leakCanaryVersion = "1.6.3"

    val GsonVersion = "2.8.4"
    val work_manager_version = "1.0.0"
    val androidPlotVersion = "1.5.6"

    val klock_version = "1.4.0"
    val kodeinVersion = "6.4.1"

    val moko_mvvm_version = "0.3.1"
    val mockk_version = "1.9.3"
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.squareup.sqldelight")
    //kotlin("serialization")
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.phillip.kmm2"
    }
}

val coroutine_version = "1.3.2"
val serializer_version = "1.2.2"
val ktor_version = "1.2.5"
val react_version = "16.9.0"
val compose_version = "1.0.1"

val sqldelight_version = "1.2.0"

val support_library_version = "28.1.1"
val constraint_layout_version = "1.1.0"
val espresso_version = "3.0.1"
val retrofit_version = "2.4.0"
val okhttp_version = "4.0.1"
val kotlinVersion = "1.4.21"
val kotlin_coroutines_version = "1.2.1"
val mockito_version = "2.18.3"

val anko_version = "0.10.8"
val buildToolsVersion = "27.0.3"
val playServicesLocationVersion = "16.0.0"
val playServicesAuthVersion = "15.0.1"
val playServicesVisionVersion = "15.0.2"

val firebaseAuthVersion = "16.0.2"
val firebaseCoreVersion = "16.0.1"
val firebaseMessagingVersion = "17.1.0"
val firebaseFireStoreVersion = "23.0.3"
val firebaseBomVersion = "28.3.1"
val firebaseDatabaseVersion = ""

val retrofitVersion = "2.3.0"
val butterknifeVersion = "10.1.0"
val daggerVersion = "2.22.1"
val picassoVersion = "2.71828"
val roomVersion = "2.0.0-beta01"
val gsonVersion = "2.8.5"
val leakCanaryVersion = "1.6.3"

val work_manager_version = "1.0.0"
val androidPlotVersion = "1.5.6"

val klock_version = "1.4.0"
val kodeinVersion = "6.4.1"

val moko_mvvm_version = "0.3.1"
val mockk_version = "1.9.3"
val androidx_lifecycle_version = "2.3.1"


kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        else -> ::iosX64
    }

    iosTarget("ios") {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //KTOR
                implementation("io.ktor:ktor-client-core:1.0.0")

                //Local DB/Cache
                implementation("com.squareup.sqldelight:runtime:$sqldelight_version")

                api("org.jetbrains.kotlin:kotlin-stdlib-common")

                // COROUTINES
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.2")

                // MOKO - MVVM
                implementation("dev.icerock.moko:mvvm-core:0.11.0")

                // SERIALIZATION
                //implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:1.0.0")

                // KODE IN
                implementation("org.kodein.di:kodein-di-core:6.4.1")
                implementation("org.kodein.di:kodein-di-erased:6.4.1")

                // FIRE STORE
                implementation("co.touchlab:firestore:0.2.5")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
//        val kotlin_version = "1.5.21"
//        val coroutine_version = "1.0.0"
//        val androidx_lifecycle_version = "1.0.0"
//        val serializer_version = "1.0.0"
//        val firebaseFireStoreVersion = "1.0.0"


        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktor_version")
                implementation ("com.squareup.sqldelight:android-driver:$sqldelight_version")

                implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion")

                // COROUTINES
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutine_version")

                // MOKO - MVVM
                //implementation("androidx.lifecycle:lifecycle-extensions:$androidx_lifecycle_version")

                // SERIALIZATION
                //implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializer_version")

                // FIREBASE
                //implementation("com.google.firebase:firebase-core:$firebaseFireStoreVersion")
                implementation("com.google.firebase:firebase-bom:$firebaseBomVersion")
                implementation("com.google.firebase:firebase-firestore-ktx:$firebaseFireStoreVersion")


            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:$ktor_version")
                implementation ("com.squareup.sqldelight:native-driver:$sqldelight_version")

                implementation("org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion")

                // COROUTINE
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutine_version")

                // SERIALIZATION
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:$serializer_version")
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(26)
        targetSdkVersion(31)
    }
}
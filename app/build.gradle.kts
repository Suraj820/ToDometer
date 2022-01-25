plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.android.gms.oss-licenses-plugin")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    compileSdk = 31
    buildToolsVersion = "31.0.0"

    defaultConfig {
        applicationId = "com.sergiobelda.androidtodometer"
        minSdk = 24
        targetSdk = 31
        versionCode = 15
        versionName = "1.2.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildTypes {
        getByName("release") {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            firebaseCrashlytics {
                mappingFileUploadEnabled = false
            }
        }
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {

    implementation(fileTree("libs") { include(listOf("*.jar")) })
    implementation(Libs.kotlin)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.AndroidX.legacy)
    implementation(Libs.AndroidX.Fragment.fragmentKtx)
    // Navigation
    implementation(Libs.AndroidX.Navigation.navigationFragmentKtx)
    implementation(Libs.AndroidX.Navigation.navigationUiKtx)
    // Lifecycle
    implementation(Libs.AndroidX.Lifecycle.liveData)
    implementation(Libs.AndroidX.Lifecycle.viewModel)
    androidTestImplementation(Libs.AndroidX.Lifecycle.archCoreTesting)
    // DataStore
    implementation(Libs.AndroidX.DataStore.preferences)
    // Room dependencies
    implementation(Libs.AndroidX.Room.roomKtx)
    implementation(Libs.AndroidX.Room.roomRuntime)
    // Required: Room compiler (avoid RuntimeException - cannot find implementation for database)
    kapt(Libs.AndroidX.Room.roomCompiler)
    androidTestImplementation(Libs.AndroidX.Room.roomTesting)

    implementation(Libs.AndroidX.pagingRuntimeKtx)

    implementation(platform(Libs.Google.Firebase.bom))
    implementation(Libs.Google.Firebase.analytics)
    implementation(Libs.Google.Firebase.crashlytics)

    testImplementation(Libs.junit)
    androidTestImplementation(Libs.AndroidX.Test.extJunit)
    androidTestImplementation(Libs.AndroidX.Test.espressoCore)

    // AndroidX Test - JVM testing
    testImplementation(Libs.AndroidX.junitKtx)
    testImplementation(Libs.AndroidX.testCoreKtx)

    implementation(Libs.Google.Material.materialComponents)

    implementation(Libs.Google.ossLicenses)

    implementation(Libs.Google.Dagger.hilt)
    kapt(Libs.Google.Dagger.hiltCompiler)

    // For instrumentation tests
    androidTestImplementation(Libs.Google.Dagger.hiltTesting)
    kaptAndroidTest(Libs.Google.Dagger.hiltCompiler)

    // For local unit tests
    testImplementation(Libs.Google.Dagger.hiltTesting)
    kaptTest(Libs.Google.Dagger.hiltCompiler)

    testImplementation(Libs.robolectric)

    testImplementation(Libs.mockk)

    implementation(Libs.timber)

    implementation(Libs.sergiobeldaCompanion)
}

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.sirketismi.azmvipattern"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sirketismi.azmvipattern"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding { enable = true }
}

val lifecycle_livedata_ktx = "2.4.0-alpha02"
val lifecycle_viewmodel = "2.4.0-alpha02"
val lifecycle_runtime = "2.4.0-alpha02"
val fragment_ktx = "1.3.2"

dependencies {
    implementation(project(":common"))
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_viewmodel")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_livedata_ktx")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_runtime")
    implementation("androidx.fragment:fragment-ktx:$fragment_ktx")

    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
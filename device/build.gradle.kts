plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
group=("com.github.Helios030")


android {
    namespace = "com.qc.device"
    compileSdk = 33
    defaultConfig{
        minSdk = 24
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}



dependencies {
    implementation ("androidx.core:core-ktx:1.10.1")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("com.android.installreferrer:installreferrer:2.2")
    implementation ("androidx.exifinterface:exifinterface:1.3.6")
    api("com.google.code.gson:gson:2.10.1")
    implementation("com.google.android.gms:play-services-ads-identifier:18.0.1")


}
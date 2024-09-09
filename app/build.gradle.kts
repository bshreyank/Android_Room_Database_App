plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.navigation.safe.args)

}

android {
    namespace = "com.example.roomappstevdzasan"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.roomappstevdzasan"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // navigation
    implementation(libs.navigationFragment)
    implementation(libs.navigationUi)

    //coroutines
    implementation(libs.coroutinesCore)
    implementation(libs.coroutinesAndroid)
    //coroutines lifecycle scopes
    implementation(libs.coroutinesViewModel)
    implementation(libs.coroutinesRunTime)

    // Room Local Database
    implementation(libs.roomRuntime)
    implementation(libs.annotationProcessor)
    implementation(libs.roomKtx)
    implementation(libs.roomTesting)

    // Lifecycle components
    implementation(libs.lifecycleExtensions)
    implementation(libs.lifecycleCommonJava8)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
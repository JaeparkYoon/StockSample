plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
}

android {
    defaultConfig {
        applicationId = "com.yjpapp.stockportfolio"
        minSdk = 23
        compileSdk = 34
        targetSdk = 34
        versionCode = 40
        versionName = "2.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            buildConfigField("boolean", "LOG_CAT", "true")
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("boolean", "LOG_CAT", "false")
        }
    }
    buildFeatures {
        dataBinding = true
        compose = true
    }
    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    lint {
        abortOnError = false
        checkReleaseBuilds = false
    }
    namespace = "com.yjpapp.stockportfolio"

}

dependencies {
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("com.github.bumptech.glide:glide:4.14.2")
    //RecyclerView Animation
    implementation("jp.wasabeef:recyclerview-animators:4.0.0")
    implementation("com.github.GrenderG:Toasty:1.5.0")
    implementation("com.google.android.material:material:1.9.0")

    //FireBase
    implementation(platform("com.google.firebase:firebase-bom:32.2.2"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-messaging:23.2.1")
    //Google Service
    implementation("com.google.android.gms:play-services-ads:22.2.0")
    implementation("com.google.android.gms:play-services-auth:20.6.0")
    //SNS Login
    implementation("com.navercorp.nid:oauth:5.2.0")
    implementation("com.facebook.android:facebook-login:5.15.3")
    //Compose
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.ui:ui-tooling:1.5.0")
    implementation("androidx.compose.foundation:foundation:1.5.0")
    implementation("androidx.compose.material:material:1.5.0")
    implementation("androidx.compose.material:material-icons-core:1.5.0")
    implementation("androidx.compose.material:material-icons-extended:1.5.0")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.0")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.5.0")
    implementation("androidx.navigation:navigation-compose:2.7.0")

    //Compose swipeLayout
    implementation("de.charlex.compose:revealswipe:1.0.0")

    //Navigation
    implementation("androidx.navigation:navigation-ui-ktx:2.7.0")

    implementation("com.github.Ibotta:Supported-Picker-Dialogs:1.0.0")

    //network
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    //kotlinx.serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    //Hilt
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("com.google.dagger:hilt-android:2.47")
    kapt("com.google.dagger:hilt-compiler:2.47")

    //Paging
    implementation("androidx.paging:paging-runtime-ktx:3.2.0")

    //Crawling library
    implementation("org.jsoup:jsoup:1.15.3")

    //Read csv
    implementation("com.opencsv:opencsv:4.4")

    //Room
    implementation("androidx.room:room-runtime:2.5.2")
    annotationProcessor("androidx.room:room-compiler:2.5.2")
    ksp("androidx.room:room-compiler:2.5.2")
}
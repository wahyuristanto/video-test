plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    id(GradlePluginId.KOTLIN_KAPT)
    id(GradlePluginId.SAFE_ARGS)
    id("kotlin-android")
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("debug"){
            buildConfigField("String", "BASE_URL", "\"https://api.chucknorris.io/jokes/\"")
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"https://api.chucknorris.io/jokes/\"")
        }
    }
    compileOptions {
        sourceCompatibility = (JavaVersion.VERSION_1_8)
        targetCompatibility = (JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(LibraryDependency.KOTLIN)
    api(LibraryDependency.KOTLIN_CORE)
    api(LibraryDependency.APPCOMPAT)
    api(LibraryDependency.MATERIAL)
    api(LibraryDependency.CONSTRAINT_LAYOUT)
    api(LibraryDependency.SHIMMER)


    api(LibraryDependency.NAVIGATION)
    api(LibraryDependency.NAVIGATION_UI)

    api(LibraryDependency.DAGGER)
    api(LibraryDependency.DAGGER_SUPPORT)

    api(LibraryDependency.OKHTTP)
    api(LibraryDependency.OKHTTP_INTERCEPTOR)
    api(LibraryDependency.CHUCK)
    api(LibraryDependency.RETROFIT)
    api(LibraryDependency.RETROFIT_GSON)

    api(LibraryDependency.LOTTIE)
    api(LibraryDependency.GLIDE)

    api(LibraryDependency.ROOM)
    api(LibraryDependency.ROOM_RUNTIME)

    api(LibraryDependency.ESPRESSOIDLING)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")


    addTestDependencies()
    addCompilerDependencies()

}
object GradlePluginId {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val KOTLIN_ANDROID_EXTENSIONS = "org.jetbrains.kotlin.android.extensions"
    const val KOTLIN_KAPT = "org.jetbrains.kotlin.kapt"
    const val SAFE_ARGS = "androidx.navigation.safeargs.kotlin"
}

object GradleDependencyVersion{
    const val GRADLE_VERSION = "4.0.0"
    
}

object GradleDependency{
    const val GRADLE = "com.android.tools.build:gradle:${GradleDependencyVersion.GRADLE_VERSION}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${CoreVersion.KOTLIN}"
    const val NAVIGATION_SAFE_ARGS = "androidx.navigation:navigation-safe-args-gradle-plugin:${CoreVersion.NAVIGATION}"
}
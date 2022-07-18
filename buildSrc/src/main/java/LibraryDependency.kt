object LibraryVersion{
    const val KOTLIN = "1.4.10"
    const val KOTLIN_CORE = "1.3.1"
    const val APPCOMPAT = "1.2.0"
    const val CONSTRAINT_LAYOUT = "2.0.1"
    const val JUNIT = "4.12"
    const val JUNITX = "1.1.2"
    const val ESPRESSO = "3.3.0"
    const val COROUTINETEST = "1.2.1"
    const val TRUTH = "1.0.1"
    const val CORETEST="2.1.0"
    const val MOCKITO="2.21.0"
    const val MOCKITOANDROID = "3.0.0"
    const val FRAGMENTTEST="1.2.4"
    const val TEST = "1.2.0"
    const val RULE = "1.3.0"

    const val MATERIAL = "1.2.0"
    const val DAGGER = "2.28.3"
    const val OKHTTP = "4.2.1"
    const val RETROFIT = "2.8.1"
    const val CHUCK = "1.1.0"
    const val LOTTIE = "3.4.4"
    const val GLIDE = "4.11.0"
    const val ROOM = "2.2.1"
    const val SHIMMER = "0.5.0"

}

object LibraryDependency {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${LibraryVersion.KOTLIN}"
    const val KOTLIN_CORE = "androidx.core:core-ktx:${LibraryVersion.KOTLIN_CORE}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${LibraryVersion.APPCOMPAT}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${LibraryVersion.CONSTRAINT_LAYOUT}"
    const val MATERIAL = "com.google.android.material:material:${LibraryVersion.MATERIAL}"
    const val SHIMMER = "com.facebook.shimmer:shimmer:${LibraryVersion.SHIMMER}"

    const val JUNIT = "junit:junit:${LibraryVersion.JUNIT}"
    const val JUNITX = "androidx.test.ext:junit:${LibraryVersion.JUNITX}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${LibraryVersion.ESPRESSO}"
    const val ESPRESSOIDLING = "androidx.test.espresso:espresso-idling-resource:${LibraryVersion.ESPRESSO}"
    const val ROOMTEST = "androidx.room:room-testing:${LibraryVersion.ROOM}"
    const val COROUTINETEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${LibraryVersion.COROUTINETEST}"
    const val TRUTH = "com.google.truth:truth:${LibraryVersion.TRUTH}"
    const val CORETEST = "androidx.arch.core:core-testing:${LibraryVersion.CORETEST}"
    const val MOCKITO = "org.mockito:mockito-core:${LibraryVersion.MOCKITO}"
    const val MOCKITOANDROID = "org.mockito:mockito-android:${LibraryVersion.MOCKITOANDROID}"
    const val FRAGMENTTEST = "androidx.fragment:fragment-testing:${LibraryVersion.FRAGMENTTEST}"
    const val RULE = "androidx.test:rules:${LibraryVersion.RULE}"


    //navigation
    const val NAVIGATION = "androidx.navigation:navigation-fragment-ktx:${CoreVersion.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${CoreVersion.NAVIGATION}"


    const val DAGGER = "com.google.dagger:dagger:${LibraryVersion.DAGGER}"
    const val DAGGER_SUPPORT = "com.google.dagger:dagger-android-support:${LibraryVersion.DAGGER}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${LibraryVersion.DAGGER}"

    const val OKHTTP = "com.squareup.okhttp3:okhttp:${LibraryVersion.OKHTTP}"
    const val OKHTTP_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${LibraryVersion.OKHTTP}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${LibraryVersion.RETROFIT}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${LibraryVersion.RETROFIT}"
    const val CHUCK = "com.readystatesoftware.chuck:library:${LibraryVersion.CHUCK}"
    const val LOTTIE = "com.airbnb.android:lottie:${LibraryVersion.LOTTIE}"
    const val GLIDE = "com.github.bumptech.glide:glide:${LibraryVersion.GLIDE}"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${LibraryVersion.GLIDE}"

    const val ROOM_RUNTIME = "androidx.room:room-runtime:${LibraryVersion.ROOM}"
    const val ROOM = "androidx.room:room-ktx:${LibraryVersion.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${LibraryVersion.ROOM}"

}

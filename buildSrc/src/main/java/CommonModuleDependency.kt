import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addTestDependencies(){
    testImplementation(LibraryDependency.JUNIT)
    testImplementation(LibraryDependency.COROUTINETEST)
    testImplementation(LibraryDependency.TRUTH)
    testImplementation(LibraryDependency.CORETEST)
    testImplementation(LibraryDependency.MOCKITO)


    debugImplementation(LibraryDependency.JUNITX)
    debugImplementation(LibraryDependency.ESPRESSO)
    debugImplementation(LibraryDependency.FRAGMENTTEST)
    debugImplementation(LibraryDependency.CORETEST)
    debugImplementation(LibraryDependency.RULE)
    debugImplementation(LibraryDependency.MOCKITOANDROID)

}

fun DependencyHandler.addCompilerDependencies(){
    kapt(LibraryDependency.ROOM_COMPILER)
    kapt(LibraryDependency.DAGGER_COMPILER)
    kapt(LibraryDependency.GLIDE_COMPILER)
}

private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

private fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)
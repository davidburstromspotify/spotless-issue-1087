plugins {
    id ("com.diffplug.spotless") version "6.1.2" apply false
}

apply(plugin = "base")

subprojects {
    apply(plugin = "java-library")

    // if this is apply directive is removed, the build will pass
    apply(plugin = "com.diffplug.spotless")

    val dummy = file("src/main/java/Dummy.java")
    dummy.parentFile.mkdirs()
    dummy.writeBytes("public class Dummy {}".toByteArray())
}

val gradleBuild = tasks.register("gradleBuild", GradleBuild::class.java) {
    tasks = listOf("help")
}

tasks.named("build").configure {
    dependsOn(gradleBuild)
}

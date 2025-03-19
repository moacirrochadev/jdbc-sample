plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
        implementation("com.mysql:mysql-connector-j:8.4.0")
        implementation("org.flywaydb:flyway-core:11.3.4")
        implementation("org.flywaydb:flyway-mysql:11.3.4")
        implementation("net.datafaker:datafaker:2.2.2")

        compileOnly("org.projectlombok:lombok:1.18.32")
        annotationProcessor("org.projectlombok:lombok:1.18.32")
    }
}
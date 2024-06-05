# Project Structure

```plaintext
project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── Main.java
│   │   │           ├── service/
│   │   │           │   ├── MyService.java
│   │   │           │   └── AnotherService.java
│   │   │           ├── model/
│   │   │           │   └── MyModel.java
│   │   │           └── util/
│   │   │               └── MyUtil.java
│   │   └── resources/
│   │       └── application.properties
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               ├── MainTest.java
│   │               └── service/
│   │                   ├── MyServiceTest.java
│   │                   └── AnotherServiceTest.java
│   └── test/
│       └── resources/
│           └── test-application.properties
└── pom.xml (for Maven) or build.gradle (for Gradle)

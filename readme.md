#Tibia-API

Java interface to interact and retrieve relevant data from [Tibia.com](http://www.tibia.com).

## Tibia-API in a Nutshell

Since CipSoft does not provide any REST interface for developers, Tibia-API works with HTML Parsers to get content
from Tibia.com pages and parse it into Java objects. The main goal of this project is to make it easy for developers
to build projects that depends on Tibia.com data (e.g. statistics).

## How to Install?

All you have to do is include Tibia-API as a dependency in your project. To do this, include Jitpack repository in your
project and the dependency itself.

### Maven

Include in your pom.xml file:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.rscarela</groupId>
        <artifactId>tibia-api</artifactId>
        <version>-SNAPSHOT</version>
    </dependency>
</dependencies>
```

### Gradle

## How to use?

TODO
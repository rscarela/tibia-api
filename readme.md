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

Include in your build.gradle file:

```
repositories {
  maven {
    url  "https://jitpack.io"
  }
}

dependencies {
  compile "com.github.rscarela:tibia-api:-SNAPSHOT"
}
```

*A note about version: since Tibia-API is pretty new, there are still no release version, so SNAPSHOT will be the default
version until there. After the first release, this doc will keep the most recent version.*

## How to use?

Using Tibia-API is pretty simple. The API is abstracting all interaction with Tibia.com, so all you have to do is to
use the client to obtain any data you want.

The first class you are about to use is called TibiaClientBuilder. This one is responsile for creating an instance of
a TibiaClient, which you will be use for every operation you'd like to.

```java

TibiaClient tibia = new TibiaClientBuilder().build();

```

Code above is enough to get an instance of a client with default properties (which shall be enough for most cases). Using
it is as simple as:

```java

List<World> worlds = tibia.worlds().fetchAll();

```
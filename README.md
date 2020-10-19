# gson_serialize


## Synopsis

Testing out how the Gson API works


## Description


## Building and running

This project was created like this:

    $ mvn archetype:generate -DgroupId=gson_serialize -DartifactId=gson_serialize -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

And the following was added to `pom.xml`

    <dependencies>
      <dependency>
          <groupId>com.google.code.gson</groupId>
          <artifactId>gson</artifactId>
          <version>2.8.5</version>
          <scope>compile</scope>
      </dependency>
    </dependencies>

To compile and package into a jar

    $ mvn package

To run with Maven

    $ mvn exec:java -Dexec.mainClass=gson_serialize.App

To run without Maven

    $ java -cp "$HOME/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar:target/gson_serialize-1.0-SNAPSHOT.jar" gson_serialize.App

There's a helper script in the project: `run.sh`

Here's a simple build/run command to re-use:

    $ mvn package && ./run.sh


Finally, Gson API docs: <https://www.javadoc.io/static/com.google.code.gson/gson/2.8.5/overview-summary.html>


## Contact

Dino Morelli <dino@ui3.info>

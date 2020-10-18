# gson_serialize


## Synopsis

Testing out how the Gson API works


## Description


## Building and running

This project was created like this:

    $ mvn archetype:generate -DgroupId=gson_serialize -DartifactId=gswork -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

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

    $ java -cp "$HOME/.m2/repository/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar:target/gswork-1.0-SNAPSHOT.jar" gson_serialize.App

There's a helper script in the project: `run.sh`

It may also be useful to run the output through `json_reformat`, which is in
the `yajl-tools` package on Debian.

Here's a simple build/run/format command to re-use:

    $ mvn package && ./run.sh | json_reformat


## Contact

Dino Morelli <dino@ui3.info>

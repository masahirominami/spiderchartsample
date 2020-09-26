# Start Maven project

c.f. https://metamug.com/article/java/build-run-java-maven-project-command-line.html

    mvn archetype:generate -DgroupId=com.yourcompany -DartifactId=myproject -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

# Dependencies

c.f. http://maven.apache.org/plugins/maven-dependency-plugin/index.html

    mvn dependency:resolve

# Compile

    mvn compile

# Execute

    mvn exec:java -Dexec.mainClass=com.mycompany.App

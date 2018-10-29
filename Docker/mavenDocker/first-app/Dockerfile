FROM sgrio/java-oracle
MAINTAINER Lukas Burda (lburda@redhat.com)
RUN apt-get update
RUN apt-get install -y maven
COPY pom.xml /usr/local/service/pom.xml
COPY src /usr/local/service/src
WORKDIR /usr/local/service
RUN mvn package
CMD ["java", "-cp", "target/first-app-1.0.jar", "org.lukasburda.dockerplaying.firstapp.App"]

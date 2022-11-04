FROM openjdk:8
EXPOSE 8080
ADD /target/BellMedia-0.0.1-SNAPSHOT.jar BellMedia-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","BellMedia-0.0.1-SNAPSHOT.jar"]
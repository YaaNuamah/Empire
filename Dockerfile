FROM adoptopenjdk:11-jre-hotspot
COPY build/libs/Empire-0.0.1-SNAPSHOT.jar  app.jar
RUN chmod 777 app.jar
EXPOSE 8050
ENTRYPOINT ["java", "-jar", "app.jar" ]

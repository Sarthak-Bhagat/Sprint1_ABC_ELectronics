FROM openjdk:11

# Copy local code to the container image.
#WORKDIR /app


COPY target/Sprint1ABCElectronics-0.0.1-SNAPSHOT.jar /app.jar
# COPY src/main/resources/application.properties /application.properties

# EXPOSE 8080

# Run the web service on container startup.
CMD  java -jar /app.jar
# CMD java -Dspring.config.location=/application.properties -jar app.jar */

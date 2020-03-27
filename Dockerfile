FROM openjdk:11

# Add Maintainer Info
LABEL maintainer="the.jordan.guinn@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/shipping-eligibility-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} shipping-eligibility-0.0.1-SNAPSHOT.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/shipping-eligibility-0.0.1-SNAPSHOT.jar"]

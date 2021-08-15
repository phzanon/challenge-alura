FROM adoptopenjdk/openjdk11
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
ARG JAR_FILE=application/web/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Drun.jvmArguments=-Xmx512m", "-Dserver.port=$PORT" ,"-Dspring.profiles.active=application-heroku" ,"-jar","/app.jar"]
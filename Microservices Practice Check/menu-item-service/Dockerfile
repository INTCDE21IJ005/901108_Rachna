FROM java:8
LABEL maintainer="sarishbiswas@gmail.com"
VOLUME /tmp
EXPOSE 8081
ADD target/menu-item-service-0.0.1-SNAPSHOT.jar menu-item-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","menu-item-service-0.0.1-SNAPSHOT.jar"]

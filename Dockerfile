FROM openjdk:11
EXPOSE 8083
ADD target/buscadorvalor-1.0.0.jar buscadorvalor.jar
ENTRYPOINT [ "java","-jar","/buscadorvalor.jar" ]
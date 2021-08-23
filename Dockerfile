FROM openjdk:11
ADD target/buscadorvalor-1.0.0.jar buscadorvalor.jar
ENTRYPOINT [ "java","-jar","/buscadorvalor.jar" ]
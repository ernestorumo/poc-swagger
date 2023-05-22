# poc-swagger
POC de configuración de Swagger con SpringDoc con despliegue en servidor TOMCAT

Montaje de entorno con Docker:
1. Descargar imagen -> docker pull tomcat:9.0.39-jdk8-adoptopenjdk-hotspot
2. Ejecutar -> docker run -it --rm -p 8888:8080 -v /mnt/d/tomcat/webapps:/usr/local/tomcat/webapps tomcat:9.0.39-jdk8-adoptopenjdk-hotspot
3. Compilar proyecto de spring y copiar a la ruta "d:/tomcat/webapps"
4. Probar url "localhost:8888/poc-swagger/swagger-ui/index.html"

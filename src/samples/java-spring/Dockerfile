FROM openjdk:8-jre-alpine

VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY target/ecoss-ambiental.jar.original /app/ecoss-ambiental.jar
EXPOSE 8081

ENTRYPOINT ["java","-Xms512m","-Xmx512m","-XX:+UnlockExperimentalVMOptions","-XX:+UseCGroupMemoryLimitForHeap","-XX:MaxRAMFraction=1","-XshowSettings:vm","-cp","app/ecoss-ambiental.jar:app/lib/*","br.com.clouddog.ecossambiental.EcossAmbientalApplication"]

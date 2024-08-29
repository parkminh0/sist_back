FROM gradle:7.6-jdk as builder
WORKDIR /app
COPY ./ ./
RUN gradle clean build --no-daemon


FROM openjdk:17-alpine
WORKDIR /app
# 터미널 명령어를 통해 생성된 build/libs/SNAPSHOT를 .(현재위치)에 복사
COPY --from=builder /app/build/libs/backend-0.0.1-SNAPSHOT.jar .


EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "backend-0.0.1-SNAPSHOT.jar" ]
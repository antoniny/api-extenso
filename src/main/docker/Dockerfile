FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade
ENV LC_ALL pt_BR.UTF-8
ENV LANG pt_BR.UTF-8
ENV LANGUAGE pt_BR.UTF-8
RUN mkdir -p /usr/local/api-extenso
ADD @project.build.finalName@.jar /usr/local/api-extenso
ADD run.sh run.sh
RUN chmod +x run.sh
CMD sh run.sh
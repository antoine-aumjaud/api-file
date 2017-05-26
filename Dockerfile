FROM openjdk:8-jre-alpine

RUN apk --no-cache add docker

LABEL maintainer "Antoine Aumjaud <antoine_dev@aumjaud.fr>"

EXPOSE 9080

WORKDIR /home/app
ADD build/distributions/api-file.tar .
VOLUME ./api-file/lib/conf
VOLUME ./logs

CMD    ./api-file/bin/api-file

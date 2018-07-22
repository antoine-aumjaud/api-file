FROM openjdk:8-jre-alpine

LABEL maintainer "Antoine Aumjaud <antoine_dev@aumjaud.fr>"

EXPOSE 9080

WORKDIR /home/app
ADD build/distributions/api-secrets.tar .
VOLUME ./api-secrets/lib/conf
VOLUME ./logs

CMD    ./api-secrets/bin/api-secrets

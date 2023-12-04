FROM --platform=linux/x86_64 public.ecr.aws/amazoncorretto/amazoncorretto:21-al2-full

ARG version

COPY target/paypal-$version.war /paypal.war

RUN mkdir /home/appserver && yum update -y && yum install -y curl telnet net-tools 



EXPOSE 8080

CMD ["java","-Xms256m", "-Xmx2048m", "-XX:MaxMetaspaceSize=256M","-XX:MetaspaceSize=32M","-Duser.timezone=UTC","-jar","/paypal.war"]

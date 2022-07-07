FROM openjdk:8

WORKDIR /automation

COPY . .

RUN wget https://services.gradle.org/distributions/gradle-6.4.1-bin.zip -P /tmp
RUN unzip -d /opt/gradle /tmp/gradle-*.zip
ENV GRADLE_HOME=/opt/gradle/gradle-6.4.1
RUN echo $GRADLE_HOME
ENV PATH=$GRADLE_HOME/bin:$PATH
RUN echo $PATH

EXPOSE 7070

ENTRYPOINT ["gradle", "clean"]
CMD ["executeFeatures"]

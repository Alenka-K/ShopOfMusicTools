FROM openjdk:11
ADD target/ShopOfMusicTools-0.0.1-SNAPSHOT.war ShopOfMusicTools-0.0.1-SNAPSHOT.war
EXPOSE 9345
CMD ["java", "-jar", "ShopOfMusicTools-0.0.1-SNAPSHOT.war"]
mvn clean package
./target/jlink-image/bin/java -Dlogback.configurationFile=logback.xml -Dprofile=local -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 --enable-preview -m nima.example/com.jojo.helidon.api.NimaAPI

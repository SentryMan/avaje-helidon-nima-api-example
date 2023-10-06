mvn clean package -P jlink
./target/jlink-image/bin/java  -Dconfig.profiles=local -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 --enable-preview -m nima.example/com.jojo.helidon.api.NimaAPI

mvn clean package -P jlink-app-image
./target/jlink-image/bin/java  -Dconfig.profiles=local -m nima.example

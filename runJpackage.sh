mvn clean package

jpackage --name avaje-helidon --module nima.example/com.jojo.helidon.api.NimaAPI --module-path ./target/modules  --add-modules nima.example \
 --win-dir-chooser --win-console
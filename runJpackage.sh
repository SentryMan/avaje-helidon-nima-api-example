mvn clean package
cd ./target 
jpackage --type app-image --name avaje-helidon --module nima.example/com.jojo.helidon.api.NimaAPI \
--module-path ./modules  --add-modules nima.example 
cd ..
./target/avaje-helidon/avaje-helidon
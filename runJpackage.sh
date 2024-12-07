mvn clean package
cd ./target 
jpackage --type app-image --name avaje-helidon --module nima.example \
--module-path ./modules  --add-modules nima.example 
cd ..
## for windows
 ./target/avaje-helidon/avaje-helidon
## for mac
## ./target/avaje-helidon.app/Contents/MacOS/avaje-helidon
## ./target/avaje-helidon.app/Contents/MacOS/avaje-helidon
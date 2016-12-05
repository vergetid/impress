mvn clean install
cd app
mvn clean install
scp ./target/app-0.1-SNAPSHOT.jar ubuntu@192.168.3.27:/home/ubuntu/

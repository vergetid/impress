mvn clean install
cd app
mvn clean install
scp ./target/app-0.1-SNAPSHOT.jar ubuntu@10.38.100.23:/home/ubuntu/ImpressDeployedJars

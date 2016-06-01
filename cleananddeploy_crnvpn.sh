mvn clean install
cd app
mvn clean install
scp ./target/app-0.1-SNAPSHOT.jar ubuntu@10.38.100.21:/home/ubuntu/ImpressDeployedJars

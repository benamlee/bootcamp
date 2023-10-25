chmod +x refresh.sh
mvn -f ./demo-junit-test clean install
mvn -f ./demo-jmeter-test clean install
docker-compose build
docker-compose up -d

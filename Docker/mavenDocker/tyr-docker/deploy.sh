set -v

# Build tyr
mvn clean package

# Remove previous tyr deployment
sudo docker rm tyr -f

# Build new tyr docker image
sudo docker build . -t tyr-wildfly

# Run docker image
sudo docker run -d -p 8080:8080 -p 9990:9990 --name tyr tyr-wildfly

# Wait for wildfly and check logs
sleep 5
sudo docker logs tyr

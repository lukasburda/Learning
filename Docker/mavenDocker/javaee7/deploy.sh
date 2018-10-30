set -v

# Build program
mvn clean package

# Remove previous image
sudo docker rm javaee7 -f

# Build new docker image
sudo docker build . -t learning/javaee7

# Run docker image
sudo docker run -d -p 8080:8080 -p 9990:9990 --name javaee7 learning/javaee7

# Get logs of JavaEE application
sudo docker logs javaee7

# Wait for message from application
sleep 5
curl http://localhost:8080/javaee/message

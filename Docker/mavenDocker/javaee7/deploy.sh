mvn clean package
sudo docker rm javaee7 -f
sudo docker build . -t learning/javaee7
sudo docker run -d -p 8080:8080 -p 9990:9990 --name javaee7 learning/javaee7
sudo docker logs javaee7
sleep 5
curl http://localhost:8080/javaee/message

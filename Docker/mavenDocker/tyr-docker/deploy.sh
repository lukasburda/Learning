mvn clean package
sudo docker rm tyr -f
sudo docker build . -t tyr-wildfly
sudo docker run -d -p 8080:8080 -p 9990:9990 -p 8787:8787 --name tyr tyr-wildfly
sleep 5
sudo docker logs tyr

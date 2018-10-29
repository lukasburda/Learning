sudo docker rm test
sudo docker build . -t testimage:latest
sudo docker run --name test -it testimage:latest

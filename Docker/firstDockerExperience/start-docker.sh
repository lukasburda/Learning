set -v

# Remove previous docker image
sudo docker rm test

# Build docker image
sudo docker build . -t testimage:latest

# Run docker image
sudo docker run --name test -it testimage:latest

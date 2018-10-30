set -v

# Build docker image
sudo docker build . -t myimage:latest

# Run docker image
sudo docker run --name mavenApp -it myimage

# Remove docker image
sudo docker rm mavenApp

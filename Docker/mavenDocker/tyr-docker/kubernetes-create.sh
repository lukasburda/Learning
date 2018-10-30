set -v

# Set docker env
eval $(minikube docker-env)

# Build image
docker build -t tyr:1.0 .

# Run in minikube
kubectl run tyr --image=tyr:1.0 --image-pull-policy=Never --port=8181

# Check that it's running
kubectl get pods

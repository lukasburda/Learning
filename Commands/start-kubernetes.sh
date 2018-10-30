set -v

# Enable services
sudo systemctl start etcd kube-apiserver kube-controller-manager kube-scheduler kubelet docker kube-proxy

# Start minikube
minikube start

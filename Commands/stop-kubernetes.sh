set -v

# Stop all Kubernetes services
sudo systemctl stop etcd kube-apiserver kube-controller-manager kube-scheduler kubelet docker kube-proxy

# Stop minikube
minikube stop

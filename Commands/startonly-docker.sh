set -v

# Enable only docker service
sudo systemctl stop etcd kube-apiserver kube-controller-manager kube-scheduler kubelet kube-proxy

# Start docker service
sudo systemctl start docker

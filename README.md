# Spring cloud stream com avro

### Ambiente
- kubernetes
- helm para instalação dos recursos

#### Helm

```
helm install kafka bitnami/kafka
helm repo add confluentinc https://packages.confluent.io/helm
helm repo update
kubectl create ns confluent
helm upgrade --install confluent-operator confluentinc/confluent-for-kubernetes
kubectl apply -f https://raw.githubusercontent.com/confluentinc/confluent-kubernetes-examples/master/quickstart-deploy/confluent-platform.yaml
```

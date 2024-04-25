1. minikube start

minikube status
2. eval $(minikube docker-env)

3. cd Ruchika/workspace/microservice-practice/k8s-example

4. docker build -t k8s-example:1.0 .

5. Create yaml file in project for deployment

6. kubectl apply -f k8s-deployment.yaml

7. check deployments using below cmd

kubectl get deployments

8. check pods -

kubectl get pods

9. check logs of pods

kubectl logs pod_name

10. Now all pods are running on different instance so create service via yaml file(k8s-service.yaml) for load balancing.

11. kubectl apply -f k8s-service.yaml

kubectl get service

12. kubectl get nodes -o wide OR minikube ip

13. to access api

http://192.168.49.2:32626/test/success

minicube ip and service port

14. minikube dashboard


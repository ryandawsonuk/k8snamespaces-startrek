# K8s Namespaces Demo

## Pre-requisites

Docker (https://docs.docker.com/install/) and minikube (https://kubernetes.io/docs/tasks/tools/install-minikube/) installed.

## How to Run

Start minikube:
 
`minikube start --memory 4000 --cpus 3`

Build images by running the following from the subdirectories:

`eval $(minikube docker-env)` <br/>
`mvn clean install`

Deploy from each subdirectory with
 
`kubectl create -f k8sdescriptor.yaml`

To see the services: 

`open http://$(minikube ip):30080` <br/>
`open http://$(minikube ip):30081` <br/>
`open http://$(minikube ip):30082` <br/>
`open http://$(minikube ip):30083` <br/>
`open http://$(minikube ip):30084` <br/>
`open http://$(minikube ip):30085` <br/>

To see everything

`kubectl get pods`

## To Clean up

From each subdirectory

`kubectl delete -f k8sdescriptor.yaml`

Stop minikube with `minikube stop`
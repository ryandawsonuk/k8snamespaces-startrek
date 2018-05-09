# K8s Namespaces Demo

## Pre-requisites

Docker (https://docs.docker.com/install/) and minikube (https://kubernetes.io/docs/tasks/tools/install-minikube/) installed.

## How to Run

Start minikube:
 
`minikube start --memory 4000 --cpus 3`

Build images by running the following from the tos and tng directories:

`eval $(minikube docker-env)` <br/>
`mvn clean install` <br/>

Deploy with
 
`kubectl create -f ./tos/k8sdescriptor.yaml` <br/>
`kubectl create -f ./tng/k8sdescriptor.yaml` <br/>

To see the services: 

`open http://$(minikube ip):30080` <br/>
`open http://$(minikube ip):30081` <br/>
`open http://$(minikube ip):30082` <br/>
`open http://$(minikube ip):30083` <br/>
`open http://$(minikube ip):30084` <br/>
`open http://$(minikube ip):30085` <br/>

To see all Pods

`kubectl get pods --all-namespaces`

## Cross the namespace divide

Go to the k8sdescrioptor for tng and replace the value of SCIENCE_OFFICER_CALL_URL (http://science-officer:8080/call) with http://science-officer.tos.svc.cluster.local:8080/call. Save the change and do:

`kubectl apply --force -f ./tng/k8sdescriptor.yaml` <br>
`kubectl get pods --namespace=tng` <br/>

Then kill the science officer pod with `kubectl delete pods science-officer-b77684cd5-4n6xk --namespace=tng` but using the pod name from the previous.

Now TNG Bridge and Captain will be calling the Science Officer of TOS.

## To Clean up

`kubectl delete namespaces tos` <br/>
`kubectl delete namespaces tng` <br/>

Stop minikube with `minikube stop`

## Credits

App based on https://github.com/spring-projects/spring-boot/tree/2.0.x/spring-boot-samples/spring-boot-sample-web-static
Images from http://www.writeups.org and http://www.movieviral.com/2013/07/05/creators-of-functional-replica-of-star-trek-enterprise-bridge-are-coming-to-comic-con/
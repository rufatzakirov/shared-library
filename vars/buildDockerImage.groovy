#! /usr/bin/env groovy
def call(){
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'password', usernameVariable: 'username')]) {
        sh 'docker login -u $username -p $password'
        sh 'docker build -t rufatzakirov/java-app:$BUILD_NUMBER .'
        sh 'docker push rufatzakirov/java-app:$BUILD_NUMBER'
    
    }
}
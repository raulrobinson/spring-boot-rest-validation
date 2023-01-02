#!groovy
/*pipeline {
    agent any
    environment {
        IMAGE='openjdk:11-jre-slim-buster'
        TAG='latest'
    }
    stages {
        stage('Build') {
            steps {
                sh "docker build --pull -t ${IMAGE}:${TAG} ."
                //sh 'docker build -t rasysbox/spring-boot-rest-validation:latest .'
            }
        }
        stage('Push to dockerhub') {
            when {
                branch 'master'
            }
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerPassword', usernameVariable: 'dockerUsername')]) {
                    sh "docker login -u ${env.dockerUsername} -p ${env.dockerPassword}"
                    sh "docker push ${env.IMAGE}:${TAG}"
                }
            }
        }
    }
}*/

pipeline {
    agent none
    stages {
  	    stage('Maven Install') {
    	    agent {
      	        docker {
        	        image 'maven:3.8.1'
                }
            }
            steps {
      	        sh 'mvn clean install'
            }
        }
        stage('Docker Build') {
    	    agent any
            steps {
      	        sh 'docker build -t rasysbox/spring-boot-rest-validation:latest .'
            }
        }
        stage('Deploy docker') {
            //sh 'docker stop springboot-deploy || true && docker rm springboot-deploy || true'
            sh 'docker run --name springboot-deploy -d -p 8085:8085 springboot-deploy:${env.BUILD_NUMBER}'
        }
    }
}
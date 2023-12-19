pipeline {
    agent any
    environment {
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
	DOCKER_IMAGE = 'test-img'
	DOCKER_CONTAINER = 'test-cnt'
    }
    stages {
        stage ('Build and Test Project') {
            steps {
                bat 'mvn clean install'
		bat 'mvn clean test'
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    docker.build("cauliflower413/${DOCKER_IMAGE}:${TAG}")
                }
            }
        }
	stage('Pushing Docker Image to Dockerhub') {
	    steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerHub') {
                        docker.image("cauliflower413/${DOCKER_IMAGE}:${TAG}").push("latest")
                    }
                }
            }
	}
        /*stage('Deploy'){
            steps {
                bat "winpty docker run --name ${DOCKER_IMAGE} -it cauliflower413/${DOCKER_IMAGE}:${TAG}"
            }
        }*/
    }
}
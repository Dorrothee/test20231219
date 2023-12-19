pipeline {
    agent any
    environment {
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
	DOCKER_IMAGE = 'jenkins-img'
	DOCKER_CONTAINER = 'jenkins-cnt'
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
                        docker.image("cauliflower413/${DOCKER_IMAGE}:${TAG}").push()
                        docker.image("cauliflower413/${DOCKER_IMAGE}:${TAG}").push("latest")
                    }
                }
            }
	}
        stage('Deploy'){
            steps {
                bat "docker stop ${DOCKER_IMAGE} | true"
                bat "docker rm ${DOCKER_IMAGE} | true"
                bat "docker run --name ${DOCKER_IMAGE} -it cauliflower413/${DOCKER_IMAGE}:${TAG}"
            }
        }
    }
}

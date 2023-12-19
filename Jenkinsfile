pipeline {
    agent any
    environment {
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
	DOCKER_IMAGE = 'img'
    }
    stages {
        stage ('Build and Test Project') {
            steps {
                bat 'mvn clean install'
		//bat 'mvn test'
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
			docker.image("cauliflower413/${DOCKER_IMAGE}:${TAG}").pull()
                    }
                }
            }
	}
        /*stage('Deploy'){
            steps {
                bat 'docker run --name ${DOCKER_IMAGE} -it cauliflower413/${DOCKER_IMAGE}:${TAG}'
            }
        }*/
    }
}

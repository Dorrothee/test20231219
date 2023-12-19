/*pipeline {
  agent any
  stages {
    //stage ('Build') {
        agent {
	  docker {
              image 'maven:3.9.5'
              args '-u=\"root\"'
          }
        }
        steps {
          sh 'mvn clean install'
        }
      //}
    stage ('Build and Test') {
        agent {
	  docker {
              image 'openjdk:17'
	      args '-u=root'
          }
        }
        steps {
	  bat 'mvn clean install'
          bat 'mvn clean test'
        }
      }
    stage('Docker Build') {
    	agent any
      steps {
      	bat 'docker build -t testJenkins:latest .'
      }
    }
    stage('Docker Push') {
    	agent any
      steps {
      	withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
        	bat "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          bat 'docker push testJenkins:latest'
        }
      }
    }
  }
}*/


pipeline {
    agent any
    environment {
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
	DOCKER_IMAGE = 'jenkins-lab'
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
                    docker.build("cauliflower413/${IMAGE_NAME}:${TAG}")
		    //bat 'docker build -t ${DOCKER_IMAGE} :latest .'
                }
            }
        }
	    stage('Pushing Docker Image to Dockerhub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
        	    bat "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                    bat 'docker push testJenkins:latest'
                    }
                }
            }
        }
    }
}

/*def DOCKER_IMAGE = 'anne738/my-repo'
                    sh "docker build -t ${DOCKER_IMAGE} -f Dockerfile ."

                    withCredentials([usernamePassword(credentialsId: 'LandPDOCKER', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
                    sh 'docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD'
                    }
                    sh "docker push ${DOCKER_IMAGE}"*/

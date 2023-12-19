pipeline {
	agent none
  stages {
    stage('Checkout') {
            steps {
                checkout scm
            }
        }
  	stage('Maven Install') {
    	agent {
      	docker {
        	image 'maven:3.5.0'
        }
      }
      steps {
      	sh 'mvn clean install'
      }
    }
    stage('Build and Test') {
            steps {
                // Build and test the Maven project
                sh 'mvn clean test'
            }
        }
    stage('Docker Build') {
    	agent any
      steps {
      	sh 'docker build -t testJenkins:latest .'
      }
    }
    stage('Docker Push') {
    	agent any
      steps {
      	withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
        	sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push testJenkins:latest'
        }
      }
    }
  }
}

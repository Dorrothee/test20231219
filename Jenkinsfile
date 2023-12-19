pipeline {
  agent {
    label 'docker' 
  }
  stages {
    /*stage ('Build') {
        agent {
	  docker {
              image 'maven:3.9.5'
              args '-u=\"root\"'
          }
        }
        steps {
          sh 'mvn clean install'
        }
      }*/
    stage ('Build and Test') {
        agent {
	  docker {
              image 'alpine'
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
}

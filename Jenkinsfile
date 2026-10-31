pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'ahmed',
                    credentialsId: 'github-secret',
                    url: 'https://github.com/A7mmad2003/DevOps-Project-2'
            }
        }

        stage('Maven Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
    }
}
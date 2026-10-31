pipeline {
    agent any

    stages {
        stage('Testing 2') {
            steps {
                git branch: 'ahmed',
                    credentialsId: 'github-token',
                    url: 'https://github.com/USERNAME/taskmanager.git'
            }
        }

        stage('Maven Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
    }
}
pipeline {
    agent any

    stages {
        stage('Test Conflict') {
            steps {
                checkout scm
            }
        }

        stage('Maven Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
    }
}

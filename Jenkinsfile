pipeline {
    agent any

    stages {
        stage('Test 1') {
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

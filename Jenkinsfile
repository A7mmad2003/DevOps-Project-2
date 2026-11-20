pipeline {
    agent any

    stages {
        stage('Testing 55') {
            steps {
                git branch: 'amine',
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
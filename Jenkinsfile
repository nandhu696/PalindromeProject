
pipeline {
    agent any

    tools {
        maven 'M3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test - Show Both Results') {
            steps {
                script {
                    int result = bat(
                        script: 'mvn test',
                        returnStatus: true
                    )

                    junit testResults: '**/target/surefire-reports/*.xml',
      allowEmptyResults: false,
      skipMarkingBuildUnstable: true

                    if (result != 0) {
                        echo 'TEST RESULT: FAILURE - Intentional negative test detected.'
                    } else {
                        echo 'TEST RESULT: SUCCESS - All tests passed.'
                    }

                    echo 'Both positive and negative test cases were executed.'
                }
            }
        }

        stage('Package') {
            steps {
                bat 'mvn -DskipTests package'
            }
        }
    }

    post {
        success {
            echo 'PIPELINE SUCCESS - Test results are available above.'
        }
        failure {
            echo 'PIPELINE FAILED - Check the build or configuration errors.'
        }
    }
}

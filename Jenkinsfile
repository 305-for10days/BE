pipeline {
    agent any

	environment {
		GPG_KEY = credentials('gpg-key')
		GPG_PASS = credentials('gpg-password')
		SPRING_IMAGE = 'for10days-spring'
		SPRING_CONTAINER = 'for10days-spring1'
        SERVER_HOST_IP = 'root@106.10.35.238'
        SSH_PORT = '2692'
	}

    stages {
        stage('git secret') {
            steps {
                script {
					sh 'gpg --batch --import ${GPG_KEY}'
					sh 'git secret reveal -p ${GPG_PASS}'
                }
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                script {
                    sh './gradlew build -x test'

                }
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                script {
                    sh './gradlew test'

                }
            }
        }

        stage('scp, ssh') {
            steps {
                echo 'scp, ssh...' 
                script {
                    sh 'scp -P ${SSH_PORT} ./build/libs/demo-0.0.1-SNAPSHOT.jar root@106.10.35.238:app.jar'
                    sh 'scp -P ${SSH_PORT} Dockerfile-main ${SERVER_HOST_IP}:Dockerfile'
                    sh 'scp -P ${SSH_PORT} deploy-main.sh ${SERVER_HOST_IP}:deploy.sh'
                    sh 'ssh ${SERVER_HOST_IP} -p ${SSH_PORT} sh ./deploy.sh ${SPRING_IMAGE} ${SPRING_CONTAINER}'
               }
            }
        }
    }
}

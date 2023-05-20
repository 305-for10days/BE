pipeline {
    agent any

	environment {
		GPG_KEY = credentials('gpg-key')
		GPG_PASS = credentials('gpg-password')
		SPRING_IMAGE = 'for10days-spring'
		SPRING_CONTAINER = 'for10days-spring1'
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
                    // Use the Gradle Wrapper if your project uses Gradle
                    sh './gradlew build -x test'

                }
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                script {
                    // Use the Gradle Wrapper if your project uses Gradle
                    sh './gradlew test'

                }
            }
        }

		stage('deploy') {
			steps {
				script {
					sh 'docker images --format="{{.Repository}}" | grep -w "${SPRING_IMAGE}" && docker rmi ${SPRING_IMAGE} || true'
 					sh 'docker ps -a --filter="name=${SPRING_CONTAINER}" --format="{{.Names}}" | grep -w "${SPRING_CONTAINER}" && (docker stop ${SPRING_CONTAINER} && docker rm ${SPRING_CONTAINER}) || true'
 					sh 'docker build -t ${SPRING_IMAGE}:latest .'
					sh 'docker run -p 8082:8080 -d --name ${SPRING_CONTAINER} ${SPRING_IMAGE}:latest'
					}
				}
			}
        }
    }

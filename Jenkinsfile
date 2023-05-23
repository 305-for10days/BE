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
                    sh "gpg --batch --import ${GPG_KEY}"
                    sh "git secret reveal -p ${GPG_PASS}"
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
                    if (env.BRANCH_NAME == 'main') {
                        sh "scp -P ${SSH_PORT} ./build/libs/demo-0.0.1-SNAPSHOT.jar ${SERVER_HOST_IP}:app.jar"
                        sh "scp -P ${SSH_PORT} Dockerfile-main ${SERVER_HOST_IP}:Dockerfile"
                        sh "scp -P ${SSH_PORT} deploy-main.sh ${SERVER_HOST_IP}:deploy.sh"
                        sh "ssh ${SERVER_HOST_IP} -p ${SSH_PORT} sh ./deploy.sh ${SPRING_IMAGE} ${SPRING_CONTAINER}"
                    } else if (env.BRANCH_NAME == 'develop') {
                        sh "docker images --format='{{.Repository}}' | grep -w '${SPRING_IMAGE}' && docker rmi ${SPRING_IMAGE} || true"
                        sh "docker ps -a --filter='name=${SPRING_CONTAINER}' --format='{{.Names}}' | grep -w '${SPRING_CONTAINER}' && (docker stop ${SPRING_CONTAINER} && docker rm ${SPRING_CONTAINER}) || true"
                        sh "docker build -t ${SPRING_IMAGE}:latest ."
                        sh "docker run -p 8082:8080 -d --name ${SPRING_CONTAINER} ${SPRING_IMAGE}:latest"
                    }
                }
            }
        }
    }
}

pipeline {
    agent any

    environment {
        DOCKER_IMAGE_TAG = "latest"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    def services = ['buku', 'anggota', 'peminjaman', 'pengembalian', 'rabbitmq']
                    for (service in services) {
                        dir(service) {
                            sh 'mvn clean package -DskipTests'
                        }
                    }
                }
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    def services = ['buku', 'anggota', 'peminjaman', 'pengembalian', 'rabbitmq']
                    for (service in services) {
                        sh "docker build -t library-${service}:${DOCKER_IMAGE_TAG} ./${service}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    sh 'docker-compose -f docker-compose-library.yml up -d'
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo 'CI/CD Pipeline Completed Successfully!'
        }
        failure {
            echo 'CI/CD Pipeline Failed!'
        }
    }
}

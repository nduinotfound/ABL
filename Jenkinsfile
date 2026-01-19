pipeline {
    agent any

    environment {
        // Nama image disesuaikan dengan docker-compose utama kamu
        DOCKER_IMAGE_TAG = "latest"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Menarik kode dari repository...'
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    // Gunakan konfigurasi Maven dari Global Tool Configuration (Manage Jenkins)
                    // Pastikan di Global Tool Configuration, Maven diberi nama 'maven-3'
                    withMaven(maven: 'maven-3') {
                        def services = ['buku', 'anggota', 'peminjaman', 'pengembalian', 'rabbitmq']
                        for (service in services) {
                            echo "Building service: ${service}"
                            dir(service) {
                                // Menambahkan flags untuk mempercepat build
                                sh 'mvn clean package -DskipTests'
                            }
                        }
                    }
                }
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    // Build image sesuai dengan nama di docker-compose.yml
                    def services = [
                        'buku': 'library-buku',
                        'anggota': 'library-anggota',
                        'peminjaman': 'library-peminjaman',
                        'pengembalian': 'library-pengembalian',
                        'rabbitmq': 'library-rabbitmq'
                    ]
                    
                    services.each { dirName, imageName ->
                        echo "Building Docker Image for: ${imageName}"
                        sh "docker build -t ${imageName}:${DOCKER_IMAGE_TAG} ./${dirName}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying to Docker Containers...'
                    // Menggunakan file docker-compose.yml utama agar infrastruktur ELK dan Monitoring tetap jalan
                    sh 'docker-compose up -d'
                }
            }
        }
    }

    post {
        always {
            echo 'Membersihkan workspace...'
            cleanWs()
        }
        success {
            echo 'CI/CD Pipeline Completed Successfully!'
        }
        failure {
            echo 'CI/CD Pipeline Failed! Periksa Console Output untuk detail error.'
        }
    }
}
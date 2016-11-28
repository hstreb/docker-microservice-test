#!groovy
node {
  stage('Preparation') {
    git 'https://github.com/hstreb/docker-microservice-test.git'
  }
  stage('Compile eureka') {
    dir('eureka-server') {
      sh "./gradlew clean distDocker -PcurrentBuild=$BUILD_NUMBER"
    }
  }
  stage('Compile product-catalog') {
    dir('product-catalog') {
      sh "./gradlew clean distDocker -PcurrentBuild=$BUILD_NUMBER"
    }
  }
  stage('Compile product-web') {
    dir('product-web') {
      sh "./gradlew clean distDocker -PcurrentBuild=$BUILD_NUMBER"
    }
  }
  stage('Run services') {
    sh "docker-compose up -d"
  }
  stage('Integration tests') {
    dir('integration-tests') {
      sleep 20
      sh "./gradlew clean test"
    }
  }
  stage('Run services') {
    sh "docker-compose stop"
  }
}
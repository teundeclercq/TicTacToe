pipeline {
    agent any
    tools {
      maven 'Maven 3.3.9'
      jdk 'jdk11'
    }
    stages {
        stage('Compile') {
          steps {
            sh 'mvn clean install package'
          }
        }
        stage('SonarQube analysis') {
          steps {
              sh 'mvn sonar:sonar -Dsonar.login=da1f85f9d071249310a45ba127a9fbd3338ee7a5'
          }
        }
        stage('Deployment') {
          steps {
              sh 'mvn tomcat7:deploy -e'
          }
        }
    }
}

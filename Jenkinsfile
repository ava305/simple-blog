pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package -Daa=33'
      }
    }
    stage('Test') {
      environment {
        TEST_ACCOUNT = credentials('test_account')
      }
      steps {

        sh 'mvn test'
        sh 'node --version'
        sh 'echo $TEST_ACCOUNT'
        sh 'echo $TEST_ACCOUNT_USR'
        sh 'echo $TEST_ACCOUNT_PSW'
        sh 'echo "hello world!"'
      }
    }
  }
  post {
    always {
      echo 'One way or another, I have finished'
      archiveArtifacts 'target/**/*.war'
      junit 'build/reports/**/*.xml'

    }

    success {
      echo 'I succeeeded'

    }

    unstable {
      echo 'I am unstable :/'

    }

    failure {
      echo 'I failed :('

    }

    changed {
      echo 'Things were different before...'

    }

  }
}
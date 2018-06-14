pipeline {
  agent any
  stages {
    stage('BuildXX') {
      steps {
        sh 'mvn clean package -Daa=33'
      }
    }
    stage('Test') {
      environment {
        TEST_ACCOUNT = credentials('test_account')
      }
      steps {

       // sh 'mvn test'
        sh 'node --version'
        sh 'echo $TEST_ACCOUNT'
        sh 'echo $TEST_ACCOUNT_USR'
        sh 'echo $TEST_ACCOUNT_PSW'
        sh 'echo "hello world!"'
      }
    }
    stage('Deploy - Staging'){
        steps {
            sh 'echo deploy staging'
        }
    }

    stage('Sanity check'){
            steps {
                input 'Does the staging environment look ok?'
            }
    }
    stage('Deploy - Production'){

        steps {
            sh 'echo production deploy'
        }
    }
  }
  post {
    always {
      echo 'One way or another, I have finished'
      archiveArtifacts 'target/**/*.war'
      junit 'target/*-reports/**/*.xml'



    }

    success {
      echo 'I succeeeded'
      mail to: 'team@mydomain.com',
                  subject: "success to build",
                  body: "success to build haha!"

    }

    unstable {
      echo 'I am unstable :/'

    }

    failure {
      echo 'I failed :('
        mail to: 'team@mydomain.com',
             subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
             body: "Something is wrong with ${env.BUILD_URL}"
    }

    changed {
      echo 'Things were different before...'

    }

  }
}
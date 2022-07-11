pipeline {
 agent any
  triggers {
    pollSCM 'H/10 * * * *'
  }
 stages {
     stage("Build") {
         steps {
             bat 'docker build -t automation:1.0.0 .'
             bat 'docker tag automation:1.0.0 automation:1.0.0'
         }
     }
     stage("Test") {
         steps {
             bat 'docker-compose run automation AllCucumber'
         }
     }
 }
}

pipeline {
 agent any
  tools {
   gradle "gradle_6"
  }
 stages {
     stage("Build") {
         steps {
             bat 'echo ==== Im Building===='
         }
     }
     stage("Test") {
         steps {
             bat 'gradle clean AllCucumber'
         }
     }
 }
}

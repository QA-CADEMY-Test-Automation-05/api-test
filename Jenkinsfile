pipeline {
 agent any
 stages {
     stage("Build") {
         steps {
             bat 'echo ==== HEllo from Other Build===='
         }
     }
     stage("Test") {
         steps {
             bat 'echo ==== Other HEllo ====='
         }
     }
 }
}

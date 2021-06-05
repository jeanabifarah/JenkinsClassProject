pipeline {
     agent any

     tools {
        maven 'Maven'
    }

     stages {
         stage ('Compile Stage') {
             steps {
                     sh 'mvn clean'
                 }
             }
                
    
         stage ('Testing Stage') {
             steps {
                     sh 'mvn compile'
                 }
             }
        
     
         stage ('Deployment Stage') {
             steps {
                     sh 'mvn test'
                 }
             
             post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
         }       
    }
     
}

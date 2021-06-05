pipeline {
     agent any

     tools {
        maven 'Maven-3.8.1'
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

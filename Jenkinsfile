pipeline{
    agent any

    stages{

        stage('Cloning from GitHub') {
                steps {
                    git branch: 'yassine', url: 'https://github.com/nizar0rchid/DevOps5eme.git'
                }
                
            }

        stage('prepare project') {
        steps {
        // The -a option is an improved recursive option, that preserve all file attributes, and also preserve symlinks.
        // The . at end of the source path is a specific cp syntax that allow to copy all files and folders, included hidden ones.
        sh "cp -a ./Backend/. ."
        sh "rm -rf ./Backend"
        // List the final content
        sh "ls -la"
        }
        }

      stage('Clean Maven'){
            steps {
                sh 'mvn clean '
            }
            
        }
        stage('Compile Project'){
            steps {
                sh 'mvn compile  -DskipTests'
            }
            
        }
        
        stage("Build & Tests") {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true clean install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
                    
        }

        stage('Sonarqube Analysis') {
          steps {
            sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
          }
        }
        
        stage('Nexus') {
          steps {
            sh 'mvn deploy -Dmaven.test.skip=true -e'
          }
        }
        stage('Docker') {
            
            steps {
                
                sh 'docker-compose up --detach'
                
            }
        }

      


}
}
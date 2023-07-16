def call(String project, String ImageTag, String dockerHubUser){
    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                     sh 'docker login -u ${dockerHubUser} -p ${dockerhubpwd}'
    }   
    sh "docker image push ${dockerHubUser}/${project}:${ImageTag}"
    sh "docker image push ${dockerHubUser}/${project}:latest"   
}


// def call(String aws_account_id, String region, String ecr_repoName){
    
//     sh """
//      aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
//      docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
//     """
// }

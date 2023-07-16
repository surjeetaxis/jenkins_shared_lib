def call(String project, String ImageTag, String dockerHubUser){
    
    sh """
     docker image build -t ${project} . 
     docker image tag ${project} ${dockerHubUser}/${project}:${ImageTag}
    """
}

// def call(String aws_account_id, String region, String ecr_repoName){
    
//     sh """
//      docker build -t ${ecr_repoName} .
//      docker tag ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
//     """
// }

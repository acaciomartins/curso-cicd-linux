def call(Object pomFile, String repositorio, String artefato){

    def pom = readMavenPom file: "${pomFile}"
    
    nexusPublisher nexusInstanceId: 'nexus3', 
    nexusRepositoryId: "${repositorio}",

    packages: [[$class: 'MavenPackage',
                mavenAssetList: [[
                    classifier: '',
                    extension: '', 
                    filePath: env.WORKSPACE+"${artefato}"]],
                mavenCoordinate: [
                    artifactId: "${pom.artifactId}",
                    groupId: "${pom.groupId}",
                    packaging: "${pom.packaging}",
                    version: "${pom.version}"]
            ]]                            
}
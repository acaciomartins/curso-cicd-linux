def call(String projectKey){
  def sonarScannerPath = tool 'SonarScanner'

  withSonarQubeEnv('SonarQubeServer'){
    sh "${sonarScannerPath}/bin/sonar-scanner -Dsonar.projectKey=${projectKey} -Dsonar.java.binaries=target/"
  }

  timeout(time:10, unit:"MINUTES"){
    waitForQualityGate abortPipeline: true
  }
}
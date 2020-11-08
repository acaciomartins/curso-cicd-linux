def call(String msg = "-"){
  def readContent = ""
  if (  fileExists("${JOB_NAME}.log") ){
    readContent = readFile "${JOB_NAME}.log"
  } 
  writeFile file: "${JOB_NAME}.log" , text: readContent + "\r\n${msg}" 
}

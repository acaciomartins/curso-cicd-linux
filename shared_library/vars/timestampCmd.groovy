def setCmd(command) {
  cmd = command
}

def runCmd() {
  timestamps {
   sh "${cmd}"
  }
}

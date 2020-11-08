package org.shared.lib

import org.json.JSONObject;
import org.json.XML;

def convertXmlToJson(String path) {
  
  println(pwd())

  def xml = readFile(path)

  JSONObject jsonContent = XML.toJSONObject(xml)

  writeFile file: path.take(path.lastIndexOf('.')) + ".json", text: jsonContent.toString()


}

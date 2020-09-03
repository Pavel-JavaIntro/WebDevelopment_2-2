package by.pavka.wd22.view;

import by.pavka.wd22.controller.TextController;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.model.parser.PredefinedTextParserFactory;
import by.pavka.wd22.model.parser.TextParser;
import by.pavka.wd22.model.reader.TextFileReader;

import java.io.IOException;

public class MainStartPage {

  public static void main(String[] args) throws IOException {
    String text =
        "Love me,    tender; love me sweet. Never let me go...    \n"
            + "Your      love makes my life complete! It's 5 o'clock!?    \"Immortal\" combat.\n"
            + "33 Dead self-flying <code> class Test() {}</code> men.\n <code>   int i = 8;\nint "
            + "j = i; String s = \"line\"; </code>";

    String text2 =  "My favorite way to read a small file is to use a BufferedReader and a " +
            "StringBuilder. It is very simple and to the point (though not particularly " +
            "effective, but good enough for most cases)."

    + "<code>BufferedReader br = new BufferedReader(new FileReader(\"file.txt\"));" +
    "try {" +
      " StringBuilder sb = new StringBuilder();" +
      " String line = br.readLine();" +

      "while (line != null) {" +
        "sb.append(line);"+
        "sb.append(System.lineSeparator());"+
        "line = br.readLine();"+
      "}"+
      "String everything = sb.toString();"+
    "} finally {"+
      "br.close();"+
    "}</code>";

    TextController textController = TextController.getInstance();
    textController.createTextNode(text);
    textController.createTextNode(text2);
    textController.createTextNode(null);
  }
}

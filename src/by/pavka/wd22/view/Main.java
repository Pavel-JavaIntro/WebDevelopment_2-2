package by.pavka.wd22.view;

import by.pavka.wd22.model.TextParserException;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.model.parser.PredefinedTextParserFactory;
import by.pavka.wd22.model.parser.TextParser;
import by.pavka.wd22.model.reader.TextFileReader;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    String text =
        "Love me,    tender; love me sweet. Never let me go...    \n"
            + "Your      love makes my life complete! It's 5 o'clock!?    \"Immortal\" combat.\n"
            + "33 Dead self-flying <code> class Test() {}</code> men.\n <code>   int i = 8;\nint "
            + "j = i; String s = \"line\"; </code>";

    TextParser textParser = PredefinedTextParserFactory.getInstance().getParser();
    TextNode result = null;
    try {
      result = textParser.parse(text);
      System.out.println(result.toText());
    } catch (TextParserException e) {
      e.printStackTrace();
      System.out.println("Unhandled: " + e.unhandledText());
    }
    String t = new TextFileReader().read();
    try {
      result = textParser.parse(t);
      System.out.println(result.toText());
    } catch (TextParserException e) {
      e.printStackTrace();
      System.out.println("Unhandled: " + e.unhandledText());
    }
  }
}

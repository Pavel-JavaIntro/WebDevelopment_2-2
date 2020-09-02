package by.pavka.wd22.view;

import by.pavka.wd22.TextParserException;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.parser.PredefinedTextParserFactory;
import by.pavka.wd22.parser.TextParser;

public class Main {
  private static final String SENTENCE_BLOCK =
      "(\"*\\d*\\s?[A-Z]{1}[\\w\\s\\-\\,\\:\\;\\'\"\\<\\>\\/\\{\\}\\(\\)\\%\\=]+[\\.\\!\\?]+\\s*)";
  public static final String CODE_BLOCK = "\\s*<code>(?s).*?</code>";
  public static final String WORD_BLOCK = "(\\s*[\\w\"\\'\\-]+)|\\p{Punct}";

  public static void main(String[] args) {
    String text =
        "Love me,    tender; love me sweet. Never let me go...    \n"
            + "Your      love makes my life complete! It's 5 o'clock!?    \"Immortal\" combat.\n"
            + "33 Dead self-flying <code> class Test() {}</code> men.\n <code>   int i = 8;\nint "
            + "j = i; String s = \"line\"; </code>";

    TextParser textParser = PredefinedTextParserFactory.getInstance().getParser();
    TextNode result = null;
    try {
      result = textParser.parse(text);
    } catch (TextParserException e) {
      e.printStackTrace();
      System.out.println("Unhandled: " + e.unhadledText() + " " + e.unhadledText().length());
    }
    System.out.println(result.toText());
  }
}

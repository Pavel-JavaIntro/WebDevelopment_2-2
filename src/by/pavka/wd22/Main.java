package by.pavka.wd22;

import by.pavka.wd22.entity.TextComposite;
import by.pavka.wd22.entity.TextLeaf;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.parser.PredefinedTextParserFactory;
import by.pavka.wd22.parser.TextParser;
import by.pavka.wd22.parser.TextParserImpl;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
  private static final String SENTENCE_BLOCK =
      "(\"*\\d*\\s?[A-Z]{1}[\\w\\s\\-\\,\\:\\;\\'\"\\<\\>\\/\\{\\}\\(\\)\\%\\=]+[\\.\\!\\?]+\\s*)";
  public static final String CODE_BLOCK = "\\s*<code>(?s).*?</code>";
  public static final String WORD_BLOCK = "(\\s*[\\w\"\\'\\-]+)|\\p{Punct}";

  public static void main(String[] args) {
    //    TextNode root = new TextComposite();
    //    TextNode child1 = new TextComposite();
    //    TextNode child2 = new TextComposite();
    //    root.add(child1);
    //    root.add(child2);
    //    TextNode leaf1 = new TextLeaf("Evening .");
    //    TextNode leaf2 = new TextLeaf("That");
    //    TextNode leaf3 = new TextLeaf("was");
    //    TextNode leaf4 = new TextLeaf("fine");
    //    TextNode leaf5 = new TextLeaf(".");
    //    child1.add(leaf1);
    //    child2.add(leaf2);
    //    child2.add(leaf3);
    //    child2.add(leaf4);
    //    child2.add(leaf5);
    //    String text = root.toString();
    //    System.out.println(text);

    String text =
        "Love me,    tender; love me sweet. Never let me go...    \n"
            + "Your      love makes my life complete! It's 5 o'clock!? \"Immortal\" combat.\n"
            + "33 Dead self-flying <code> class Test() {}</code> men.\n <code>   int i = 8;\nint " +
                "j " +
                "= " +
                "i; String s = \"line\";" +
                "</code>";
//    TextParser textParser = new TextParserImpl(SENTENCE_BLOCK, CODE_BLOCK);
//    TextParser childParser = new TextParserImpl(null, WORD_BLOCK + "|" + CODE_BLOCK);
//    textParser.setChild(childParser);
    TextParser textParser = PredefinedTextParserFactory.getInstance().getParser();
    TextNode result = textParser.parse(text);
    System.out.println("Parsed");
    System.out.println(result.toString());

  }
}

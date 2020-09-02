package by.pavka.wd22.view;

import by.pavka.wd22.model.TextParserException;
import by.pavka.wd22.entity.TextNode;

public class TextNodePrinter {
  public static void printTextFromNode(TextNode textNode) {
    System.out.println(textNode.toText());
  }

  public static void printParserException(TextParserException exception) {
    exception.printStackTrace();
    if (exception.getTextNode() != null) {
      System.out.println(exception.getTextNode());
      System.out.println(exception.unhandledText());
    }
  }
}

package by.pavka.wd22.view;

import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.entity.TextNode;

public class EndPage {
  public static void displayTextFromNode(TextNode textNode) {
    System.out.println("PARSED TEXT: ");
    System.out.println(textNode.toText());
    System.out.println("RAW TEXT: ");
    System.out.println(textNode);
    System.out.println();
  }

  public static void displayError(TextProcessingException exception) {
    System.out.println("EXCEPTION: ");
    exception.printStackTrace();
    if (exception.getTextNode() != null) {
      System.out.println("IT HAS BEEN PARSED: ");
      System.out.println(exception.getTextNode().toText());
      System.out.println("IT HAS NOT BEEN PARSED: ");
      System.out.println(exception.unhandledText());
    }
    System.out.println();
  }
}

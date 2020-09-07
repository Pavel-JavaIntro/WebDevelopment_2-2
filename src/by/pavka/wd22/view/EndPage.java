package by.pavka.wd22.view;

import by.pavka.wd22.model.TextProcessingException;

public class EndPage {

  private EndPage() {}

  public static void displayResult(String result) {
    System.out.println(result);
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

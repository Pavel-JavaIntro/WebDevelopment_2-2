package by.pavka.wd22.controller;

import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.model.parser.PredefinedTextParserFactory;
import by.pavka.wd22.model.parser.TextParser;
import by.pavka.wd22.view.EndPage;

public class TextController {
  private static final TextController instance = new TextController();

  private TextController() {}

  public static TextController getInstance() {
    return instance;
  }

  public void createAndDisplayTextNode(String input) {
    TextParser textParser = PredefinedTextParserFactory.getInstance().getParser();
    TextNode result;
    if (input == null) {
      try {
        result = textParser.parseFromFile();
      } catch (TextProcessingException e) {
        EndPage.displayError(e);
        return;
      }
    } else {
      try {
        result = textParser.parse(input);
      } catch (TextProcessingException e) {
        EndPage.displayError(e);
        return;
      }
    }
    EndPage.displayTextFromNode(result);
  }
}

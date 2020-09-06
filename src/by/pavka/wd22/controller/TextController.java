package by.pavka.wd22.controller;

import by.pavka.wd22.controller.request.TextRequest;
import by.pavka.wd22.controller.response.TextResponse;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.entity.impl.TextComposite;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.model.parser.PredefinedTextParserFactory;
import by.pavka.wd22.model.parser.TextParser;
import by.pavka.wd22.model.service.TextService;
import by.pavka.wd22.view.EndPage;

import java.util.ArrayList;

public class TextController {
  private static final TextController instance = new TextController();

  private TextController() {}

  public static TextController getInstance() {
    return instance;
  }

  public void dispatch(TextRequest request) {
    String command = request.command();
    TextService service = TextServiceDispatcher.getService(command);
    try {
      TextResponse result = service.process(request.getData());
      EndPage.displayResult(result.display());
    } catch (TextProcessingException e) {
      EndPage.displayError(e);
    }
  }
}

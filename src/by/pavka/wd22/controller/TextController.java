package by.pavka.wd22.controller;

import by.pavka.wd22.controller.request.TextRequest;
import by.pavka.wd22.controller.response.TextResponse;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.model.service.TextService;
import by.pavka.wd22.view.EndPage;

public class TextController {
  private static final TextController instance = new TextController();

  private TextController() {}

  public static TextController getInstance() {
    return instance;
  }

  public <T, V> void dispatch(TextRequest<T> request) {
    String command = request.command();
    TextService<T, V> service = TextServiceDispatcher.getService(command);
    try {
      TextResponse<V> result = service.process(request.getData());
      EndPage.displayResult(result.display());
    } catch (TextProcessingException e) {
      EndPage.displayError(e);
    }
  }
}

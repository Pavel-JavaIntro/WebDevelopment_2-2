package by.pavka.wd22.controller.request.impl;

import by.pavka.wd22.controller.request.TextRequest;

public class FirstSentenceWordRequest extends TextRequest<String> {
  public FirstSentenceWordRequest(String data) {
    super(data);
  }

  @Override
  public String command() {
    return "FIRST_SENTENCE_WORD";
  }
}

package by.pavka.wd22.controller.request.impl;

import by.pavka.wd22.controller.request.TextRequest;

public class WordNumberRequest extends TextRequest<String> {
  public WordNumberRequest(String data) {
    super(data);
  }

  @Override
  public String command() {
    return "WORDNUMBER";
  }
}

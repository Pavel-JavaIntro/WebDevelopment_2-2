package by.pavka.wd22.controller.response.impl;

import by.pavka.wd22.controller.response.TextResponse;

public class FirstSentenceWordResponse extends TextResponse<String> {
  public FirstSentenceWordResponse(String result) {
    super(result);
  }

  @Override
  public String display() {
    return "The word from the first sentence absent from the others is:\n" + getResult();
  }
}

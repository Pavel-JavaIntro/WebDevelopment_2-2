package by.pavka.wd22.controller.response.impl;

import by.pavka.wd22.controller.response.TextResponse;
import by.pavka.wd22.entity.TextNode;

import java.util.List;

public class WordNumberResponse extends TextResponse<List<TextNode>> {
  public WordNumberResponse(List<TextNode> result) {
    super(result);
  }

  @Override
  public String display() {
    StringBuilder stringBuilder = new StringBuilder("SORTED SENTENCES:\n");
    for (TextNode sentence : getResult()) {
      stringBuilder.append(sentence.toText());
    }
    return stringBuilder.toString();
  }
}

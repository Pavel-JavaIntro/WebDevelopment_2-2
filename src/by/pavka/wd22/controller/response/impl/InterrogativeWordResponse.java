package by.pavka.wd22.controller.response.impl;

import by.pavka.wd22.controller.response.TextResponse;
import by.pavka.wd22.entity.impl.TextLeaf;

import java.util.Set;

public class InterrogativeWordResponse extends TextResponse<Set<TextLeaf>> {
  public InterrogativeWordResponse(Set<TextLeaf> result) {
    super(result);
  }

  @Override
  public String display() {
    StringBuilder stringBuilder = new StringBuilder("Words from interrogative sentences:\n");
    for (TextLeaf leaf : getResult()) {
      stringBuilder.append(leaf.toText());
    }
    return stringBuilder.toString();
  }
}

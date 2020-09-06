package by.pavka.wd22.model.service.impl;

import by.pavka.wd22.controller.response.impl.ReadTextResponse;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.model.service.TextService;

public class ReadTextService implements TextService<String, TextNode> {
  @Override
  public ReadTextResponse process(String data) throws TextProcessingException {
    TextNode result = constructNode(data);
    return new ReadTextResponse(result);
  }
}

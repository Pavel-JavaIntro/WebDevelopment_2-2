package by.pavka.wd22.model.service.impl;

import by.pavka.wd22.controller.response.impl.ReadTextResponse;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.entity.impl.TextComposite;
import by.pavka.wd22.entity.impl.TextLeaf;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.model.parser.TextLeafFilter;
import by.pavka.wd22.model.service.TextService;

import java.util.ArrayList;
import java.util.List;

/*
 * This service exchanges the first and the last word in each sentence
 */
public class ExchangeWordService implements TextService<String, TextNode> {
  public static final String WORD = "[\\w\"'-]+";

  @Override
  public ReadTextResponse process(String data) throws TextProcessingException {
    TextNode node = constructNode(data);
    if (node.isLeaf()) {
      return new ReadTextResponse(node);
    }
    List<TextNode> children = ((TextComposite) node).listChildren();
    TextLeafFilter textLeafFilter = new TextLeafFilter(WORD);
    for (TextNode child : children) {
      if (!child.isLeaf()) {
        List<TextLeaf> leaves =
            textLeafFilter.filter(((TextComposite) child).listLeaves(new ArrayList<>()));
        TextLeaf first = leaves.get(0);
        TextLeaf last = leaves.get(leaves.size() - 1);
        String firstValue = first.toText();
        first.setValue(last.toText());
        last.setValue(firstValue);
      }
    }
    return new ReadTextResponse(node);
  }
}

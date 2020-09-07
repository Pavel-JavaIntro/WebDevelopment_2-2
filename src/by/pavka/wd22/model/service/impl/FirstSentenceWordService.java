package by.pavka.wd22.model.service.impl;

import by.pavka.wd22.controller.response.TextResponse;
import by.pavka.wd22.controller.response.impl.FirstSentenceWordResponse;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.entity.impl.TextComposite;
import by.pavka.wd22.entity.impl.TextLeaf;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.model.parser.TextLeafFilter;
import by.pavka.wd22.model.service.TextService;

import java.util.ArrayList;
import java.util.List;

public class FirstSentenceWordService implements TextService<String, String> {
  public static final String WORD = "[\\w\"'-]+";

  @Override
  public TextResponse<String> process(String data) throws TextProcessingException {
    TextNode node = constructNode(data);
    if (node.isLeaf()) {
      return new FirstSentenceWordResponse("");
    }
    List<TextNode> children = ((TextComposite) node).listChildren();
    int length = children.size();
    TextComposite firstSentence = null;
    int index = 0;
    do {
      if (!children.get(index).isLeaf()) {
        firstSentence = (TextComposite) children.get(index);
      }
      index++;
    } while (index < length && firstSentence == null);
    if (firstSentence == null) {
      return new FirstSentenceWordResponse("");
    }
    TextLeafFilter textLeafFilter = new TextLeafFilter(WORD);
    List<TextLeaf> firstSentenceWords =
        textLeafFilter.filter(firstSentence.listLeaves(new ArrayList<>()));
    List<TextLeaf> otherSentenceWords = new ArrayList<>();
    for (int i = index++; i < length; i++) {
      TextNode childNode = children.get(i);
      if (!childNode.isLeaf()) {
        otherSentenceWords.addAll(
            textLeafFilter.filter(((TextComposite) childNode).listLeaves(new ArrayList<>())));
      }
    }
    String result = "";
    for (TextLeaf word : firstSentenceWords) {
      if (!otherSentenceWords.contains(word)) {
        result = word.toString();
        break;
      }
    }
    return new FirstSentenceWordResponse(result);
  }
}

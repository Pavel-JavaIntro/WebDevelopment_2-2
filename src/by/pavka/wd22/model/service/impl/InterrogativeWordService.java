package by.pavka.wd22.model.service.impl;

import by.pavka.wd22.controller.request.impl.InterrogativeWordRequest;
import by.pavka.wd22.controller.response.impl.InterrogativeWordResponse;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.entity.impl.TextComposite;
import by.pavka.wd22.entity.impl.TextLeaf;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.model.parser.TextLeafFilter;
import by.pavka.wd22.model.service.TextService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * This service returns all unique words, which length is equal to a given one, from interrogative sentences
*/
public class InterrogativeWordService
    implements TextService<InterrogativeWordRequest.StringAndNumber, Set<TextLeaf>> {
  public static final String WORD = "[\\w\"'-]+";

  @Override
  public InterrogativeWordResponse process(InterrogativeWordRequest.StringAndNumber data)
      throws TextProcessingException {
    String input = data.getInput();
    int numberOfLetters = data.getNumberOfLetters();
    TextNode node = constructNode(input);
    if (node.isLeaf()) {
      return new InterrogativeWordResponse(new HashSet<>());
    }
    List<TextLeaf> words = new ArrayList<>();
    TextLeafFilter textFilter = new TextLeafFilter(WORD);
    for (TextNode child : ((TextComposite) node).listChildren()) {
      if (!child.isLeaf() && child.toText().endsWith("?")) {
        words.addAll(textFilter.filter(((TextComposite) child).listLeaves(new ArrayList<>())));
      }
    }
    Set<TextLeaf> result = new HashSet<>();
    for (TextLeaf leaf : words) {
      if (leaf.toString().length() == numberOfLetters) {
        result.add(leaf);
      }
    }
    return new InterrogativeWordResponse(result);
  }
}

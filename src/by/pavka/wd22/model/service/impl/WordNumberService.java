package by.pavka.wd22.model.service.impl;

import by.pavka.wd22.controller.response.impl.WordNumberResponse;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.entity.impl.TextComposite;
import by.pavka.wd22.entity.impl.TextLeaf;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.model.parser.TextLeafFilter;
import by.pavka.wd22.model.service.TextService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * This service sorts sentences of the text by their word numbers
 */
public class WordNumberService implements TextService<String, List<TextNode>> {
  public static final String WORD = "[\\w\"'-]+";

  @Override
  public WordNumberResponse process(String data) throws TextProcessingException {
    TextNode node = constructNode(data);
    if (node.isLeaf()) {
      return new WordNumberResponse(new ArrayList<>());
      }
    List<TextNode> sentences = new ArrayList<>();
    for (TextNode child : ((TextComposite)node).listChildren()) {
      if (!child.isLeaf()) {
        sentences.add(child);
      }
    }
    sentences.sort(new WordNumberComparator());
    return new WordNumberResponse(sentences);
  }

  public static class WordNumberComparator implements Comparator<TextNode> {

    @Override
    public int compare(TextNode o1, TextNode o2) {
      TextLeafFilter filter = new TextLeafFilter(WORD);
      List<TextLeaf> first = findFilteredLeaves(o1, filter);
      List<TextLeaf> second = findFilteredLeaves(o2, filter);
      return first.size() - second.size();
    }

    private List<TextLeaf> findFilteredLeaves(TextNode node, TextLeafFilter textFilter) {
      List<TextLeaf> result = new ArrayList<>();
      if (!node.isLeaf()) {
        result.addAll(textFilter.filter(((TextComposite)node).listLeaves(new ArrayList<>())));
      }
      return result;
    }
  }
}

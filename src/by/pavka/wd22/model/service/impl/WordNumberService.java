package by.pavka.wd22.model.service.impl;

import by.pavka.wd22.controller.response.TextResponse;
import by.pavka.wd22.controller.response.impl.WordNumberResponse;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.entity.impl.TextComposite;
import by.pavka.wd22.entity.impl.TextLeaf;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.model.parser.TextLeafFilter;
import by.pavka.wd22.model.service.TextService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordNumberService implements TextService<String, List<TextNode>> {
  public static final String WORD = "[\\w\"'-]+";

  @Override
  public TextResponse<List<TextNode>> process(String data) throws TextProcessingException {
    TextNode node = constructNode(data);
    if (node.isLeaf()) {
      return new WordNumberResponse(new ArrayList<>());
      }
    List<TextNode> sentences = new ArrayList<>();
    for (TextNode child : ((TextComposite)node).listChildren()) {
      if (!child.isLeaf()) {
        sentences.add((TextComposite)child);
      }
    }
    Collections.sort(sentences, new WordNumberComparator());
    return new WordNumberResponse(sentences);
  }

  public static class WordNumberComparator implements Comparator<TextNode> {

    @Override
    public int compare(TextNode o1, TextNode o2) {
      TextLeafFilter filter = new TextLeafFilter(WORD);
      List<TextLeaf> first = new ArrayList<>();
      if (!o1.isLeaf()) {
        List<TextLeaf> wordBlocks = ((TextComposite)o1).listLeaves(new ArrayList<>());
        for (TextLeaf leaf : wordBlocks) {
          if (filter.validate(leaf)) {
            first.add(leaf);
          }
        }
      }
      List<TextLeaf> second = new ArrayList<>();
      if (!o2.isLeaf()) {
        List<TextLeaf> wordBlocks = ((TextComposite)o2).listLeaves(new ArrayList<>());
        for (TextLeaf leaf : wordBlocks) {
          if (filter.validate(leaf)) {
            second.add(leaf);
          }
        }
      }
      return first.size() - second.size();
    }
  }
}

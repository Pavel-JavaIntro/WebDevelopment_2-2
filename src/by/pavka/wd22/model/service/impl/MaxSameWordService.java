package by.pavka.wd22.model.service.impl;

import by.pavka.wd22.controller.response.TextResponse;
import by.pavka.wd22.controller.response.impl.MaxSameWordResponse;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.entity.impl.TextComposite;
import by.pavka.wd22.entity.impl.TextLeaf;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.model.parser.TextLeafFilter;
import by.pavka.wd22.model.service.TextService;

import java.util.*;

public class MaxSameWordService implements TextService<String, MaxSameWordService.MaxSameWord> {

  public static final String WORD = "[\\w\"'-]+";

  @Override
  public TextResponse<MaxSameWord> process(String data) throws TextProcessingException {
    Map<TextLeaf, Integer> results = new HashMap<>();
    TextLeafFilter filter = new TextLeafFilter(WORD);
    TextNode node = constructNode(data);
    if (node.isLeaf()) {
      return new MaxSameWordResponse(new MaxSameWord("", 0));
    }
    List<TextNode> sentences = ((TextComposite) node).listChildren();
    for (TextNode sentence : sentences) {
      if (!sentence.isLeaf()) {
        Set<TextLeaf> differentWords =
            new HashSet<>(((TextComposite) sentence).listLeaves(new ArrayList<>()));
        for (TextLeaf word : differentWords) {
          if (filter.validate(word)) {
            if (results.containsKey(word)) {
              int num = results.get(word) + 1;
              results.put(word, num);
            } else {
              results.put(word, 1);
            }
          }
        }
      }
    }
    int max = Collections.max(results.values());
    String mostFrequent = null;
    for (Map.Entry<TextLeaf, Integer> entry : results.entrySet()) {
      if (entry.getValue().equals(max)) {
        mostFrequent = entry.getKey().toString();
      }
    }
    return new MaxSameWordResponse(new MaxSameWord(mostFrequent, max));
  }

  public static class MaxSameWord {
    private final String word;
    private final int repeat;

    public MaxSameWord(String word, int repeat) {
      this.word = word;
      this.repeat = repeat;
    }

    public String toText() {
      return String.format("Word \"%s\" is represented in %d sentences", word, repeat);
    }
  }
}

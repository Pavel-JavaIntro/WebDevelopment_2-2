package by.pavka.wd22.model.parser;

import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.entity.TextNode;

public interface TextParser {
  TextNode parse(String text) throws TextProcessingException;
  TextNode parseFromFile() throws TextProcessingException;
  void setChild(TextParser child);
}

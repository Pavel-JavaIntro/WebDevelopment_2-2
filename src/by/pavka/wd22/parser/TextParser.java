package by.pavka.wd22.parser;

import by.pavka.wd22.entity.TextNode;

public interface TextParser {
  TextNode parse(String text);
  void setChild(TextParser child);
}

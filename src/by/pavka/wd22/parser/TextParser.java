package by.pavka.wd22.parser;

import by.pavka.wd22.entity.TextNode;

public interface TextParser {
  boolean hasNext();
  TextNode parseNext();
  void addChild(TextParser child);
  void addSibling(TextParser sibling);
}

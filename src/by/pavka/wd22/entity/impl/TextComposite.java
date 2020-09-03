package by.pavka.wd22.entity.impl;

import by.pavka.wd22.entity.TextNode;

import java.util.*;

public class TextComposite implements TextNode {
  private Deque<TextNode> textNodes;
  private String unhandledText;

  public TextComposite() {
    textNodes = new ArrayDeque<>();
  }

  @Override
  public void setUnhandledText(String unhandledText) {
    this.unhandledText = unhandledText;
  }

  @Override
  public String getUnhandledText() {
    return unhandledText;
  }

  @Override
  public boolean add(TextNode textNode) {
    return textNodes.offer(textNode);
  }

  @Override
  public Iterator<TextNode> createIterator() {
    return textNodes.iterator();
  }

  @Override
  public String toText() {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<TextNode> iterator = createIterator();
    while (iterator.hasNext()) {
      stringBuilder.append(iterator.next().toText());
    }
    return stringBuilder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TextComposite)) {
      return false;
    }
    TextComposite that = (TextComposite) o;
    return Arrays.equals(textNodes.toArray(), that.textNodes.toArray());
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(textNodes.toArray());
  }

  @Override
  public String toString() {
    return textNodes.toString();
  }
}

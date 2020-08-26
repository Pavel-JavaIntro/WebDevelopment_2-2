package by.pavka.wd22.entity;

import java.util.*;

public class TextComposite implements TextNode {
  private Deque<TextNode> textNodes;

  public TextComposite() {
    textNodes = new ArrayDeque<>();
  }

  @Override
  public boolean isLeaf() {
    return false;
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
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<TextNode> iterator = createIterator();
    while (iterator.hasNext()) {
      stringBuilder.append(iterator.next().toString());
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
}

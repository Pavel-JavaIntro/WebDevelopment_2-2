package by.pavka.wd22.entity.impl;

import by.pavka.wd22.entity.TextNode;

import java.util.*;

public class TextComposite implements TextNode {
  private final List<TextNode> textNodes;
  private String unhandledText;

  public TextComposite() {
    textNodes = new ArrayList<>();
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
    return textNodes.add(textNode);
  }

  @Override
  public boolean isLeaf() {
    return false;
  }

  @Override
  public String toText() {
    StringBuilder stringBuilder = new StringBuilder();
    for (TextNode node : textNodes) {
      stringBuilder.append(node.toText());
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
    return textNodes.equals(that.textNodes);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(textNodes.toArray());
  }

  @Override
  public String toString() {
    return textNodes.toString();
  }

  @Override
  public TextComposite clone() {
    TextComposite copy = new TextComposite();
    copy.setUnhandledText(unhandledText);
    for (TextNode node : textNodes) {
      TextNode copyNode = node.clone();
      copy.add(copyNode);
    }
    return copy;
  }

  public List<TextNode> listChildren() {
    return textNodes;
  }

  public List<TextLeaf> listLeaves(List<TextLeaf> leaves) {
    for (TextNode node : textNodes) {
      if (node.isLeaf()) {
        leaves.add((TextLeaf) node);
      } else {
        ((TextComposite) node).listLeaves(leaves);
      }
    }
    return leaves;
  }
}

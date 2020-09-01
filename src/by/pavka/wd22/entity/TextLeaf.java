package by.pavka.wd22.entity;

import java.util.Iterator;

public class TextLeaf implements TextNode {
  private String value;

  public TextLeaf(String value) {
    if (value != null) {
      this.value = value;
    } else {
      this.value = "";
    }
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean add(TextNode textNode) {
    return false;
  }

  @Override
  public Iterator<TextNode> createIterator() {
    return new TextLeafIterator();
  }

  @Override
  public String toText() {
    String processedValue = value;
    if (value.startsWith(" ") | value.startsWith("\t")) {
      processedValue = value.replaceAll("^[ \t]+", " ");
    }
    return " LEAF " + processedValue;
  }

  @Override
  public String toString() {
    return getValue().trim();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TextLeaf)) {
      return false;
    }
    TextLeaf textLeaf = (TextLeaf) o;
    return value.equals(textLeaf.value);
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }
}

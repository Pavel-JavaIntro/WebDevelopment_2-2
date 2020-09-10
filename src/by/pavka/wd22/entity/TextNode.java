package by.pavka.wd22.entity;

import java.io.Serializable;

public interface TextNode extends Cloneable, Serializable {
  boolean add(TextNode textNode);

  boolean isLeaf();

  void setUnhandledText(String text);

  String getUnhandledText();

  String toText();

  TextNode clone();
}

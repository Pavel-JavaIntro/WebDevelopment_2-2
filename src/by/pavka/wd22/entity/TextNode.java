package by.pavka.wd22.entity;

public interface TextNode extends Cloneable {
  boolean add(TextNode textNode);

  boolean isLeaf();

  void setUnhandledText(String text);

  String getUnhandledText();

  String toText();

  TextNode clone();
}

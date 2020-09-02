package by.pavka.wd22.entity;

import java.util.Iterator;

public interface TextNode {
    boolean add(TextNode textNode);
    Iterator<TextNode> createIterator();
    void setUnhandledText(String text);
    String getUnhandledText();
    String toText();
}

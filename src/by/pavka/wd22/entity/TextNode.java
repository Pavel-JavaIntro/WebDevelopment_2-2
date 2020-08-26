package by.pavka.wd22.entity;

import java.util.Iterator;

public interface TextNode {
    boolean isLeaf();
    boolean add(TextNode textNode);
    Iterator<TextNode> createIterator();
    String toString();
}

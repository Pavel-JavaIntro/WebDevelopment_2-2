package by.pavka.wd22.entity;

import java.text.StringCharacterIterator;
import java.util.Iterator;
import java.util.Objects;

public class TextLeaf implements TextNode {
    private String value;

    public TextLeaf(String value) {
        if (value != null) {
            this.value = value;
        } else {
            this.value = "";
        }
    }

    @Override
    public boolean isLeaf() {
        return true;
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
    public String toString() {
        return value;
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

package by.pavka.wd22.model.parser;

import by.pavka.wd22.entity.impl.TextLeaf;

public class TextLeafFilter {
    private final String pattern;

    public TextLeafFilter(String pattern) {
        this.pattern = pattern;
    }

    public boolean validate(TextLeaf leaf) {
        return leaf.toString().matches(pattern);
    }
}

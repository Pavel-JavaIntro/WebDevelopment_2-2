package by.pavka.wd22.model.parser;

import by.pavka.wd22.entity.impl.TextLeaf;

import java.util.ArrayList;
import java.util.List;

public class TextLeafFilter {
    private final String pattern;

    public TextLeafFilter(String pattern) {
        this.pattern = pattern;
    }

    public boolean validate(TextLeaf leaf) {
        if (leaf == null || pattern == null) {
            return false;
        }
        return leaf.toString().matches(pattern);
    }

    public List<TextLeaf> filter(List<TextLeaf> leaves) {
        List<TextLeaf> result = new ArrayList<>();
        for (TextLeaf leaf : leaves) {
            if (validate(leaf)) {
                result.add(leaf);
            }
        }
        return result;
    }
}

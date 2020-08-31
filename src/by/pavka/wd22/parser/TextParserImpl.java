package by.pavka.wd22.parser;

import by.pavka.wd22.entity.TextComposite;
import by.pavka.wd22.entity.TextLeaf;
import by.pavka.wd22.entity.TextNode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParserImpl implements TextParser {
  private String compositeFormat;
  private String leafFormat;
  private TextParser child;

  public TextParserImpl(String compositeFormat, String leafFormat) {
    // TODO check null
    this.compositeFormat = compositeFormat;
    this.leafFormat = leafFormat;
  }

  @Override
  public TextNode parse(String text, TextNode parent) {
    TextComposite result = new TextComposite();
    while (!text.isEmpty()) {
      String fragment;
      switch (nextNodeType(text)) {
        case NONE:
          result.setUnhandledText(text);
          return result;
        case LEAF:
          //TODO
          fragment = TextNodeType.LEAF.getTextFragment();
          System.out.println("INSIDE SWITCH LEAF " + fragment);
          TextLeaf leaf = new TextLeaf(fragment);
          result.add(leaf);
          text = text.substring(fragment.length());
          break;
        case COMPOSITE:
          // TODO
          fragment = TextNodeType.COMPOSITE.getTextFragment();
          System.out.println("INSIDE SWITCH COMPOSITE " + fragment);
          TextNode composite = child.parse(fragment, null);
          result.add(composite);
          text = text.substring(fragment.length());
          break;
        default:
      }
    }
    if (parent != null) {
      parent.add(result);
    }
    return result;
  }

  @Override
  public void setChild(TextParser child) {
    this.child = child;
  }

  private TextNodeType nextNodeType(String text) {
    Pattern compositePattern = null;
    Pattern leafPattern = null;
    if (compositeFormat != null) {
      compositePattern = Pattern.compile(compositeFormat);
    }
    if (leafFormat != null) {
      leafPattern = Pattern.compile(leafFormat);
    }
    String message = null;
    if (leafPattern != null) {
      Matcher leafMatcher = leafPattern.matcher(text);
      if (leafMatcher.lookingAt()) {
        message = leafMatcher.group();
        TextNodeType.LEAF.setTextFragment(message);
        return TextNodeType.LEAF;
      }
    }
    if (compositePattern != null) {
      Matcher compositeMatcher = compositePattern.matcher(text);
      if (compositeMatcher.lookingAt()) {
        message = compositeMatcher.group();
        TextNodeType.COMPOSITE.setTextFragment(message);
        return TextNodeType.COMPOSITE;
      }
    }
    return TextNodeType.NONE;
  }

  private enum TextNodeType {
    COMPOSITE,
    LEAF,
    NONE;
    private String textFragment;

    public String getTextFragment() {
      return textFragment;
    }

    public void setTextFragment(String textFragment) {
      this.textFragment = textFragment;
    }
  }
}

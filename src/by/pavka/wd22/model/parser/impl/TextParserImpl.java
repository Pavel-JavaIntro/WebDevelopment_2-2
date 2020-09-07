package by.pavka.wd22.model.parser.impl;

import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.entity.impl.TextComposite;
import by.pavka.wd22.entity.impl.TextLeaf;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.model.parser.TextParser;
import by.pavka.wd22.model.reader.TextFileReader;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParserImpl implements TextParser {
  private String compositeFormat;
  private String leafFormat;
  private TextParser child;

  public TextParserImpl(String compositeFormat, String leafFormat) {
    this.compositeFormat = compositeFormat;
    this.leafFormat = leafFormat;
  }

  @Override
  public TextNode parse(String text) throws TextProcessingException {
    TextNode result = new TextComposite();
    while (text != null && !text.isEmpty()) {
      String textFragment;
      switch (nextNodeType(text)) {
        case NONE:
          result.setUnhandledText(text);
          throw new TextProcessingException("Text not parsed", result);
        case LEAF:
          textFragment = TextNodeType.LEAF.getTextFragment();
          System.out.println("LEAF: " + textFragment);
          TextNode leaf = new TextLeaf(textFragment);
          result.add(leaf);
          text = text.substring(textFragment.length());
          break;
        case COMPOSITE:
          textFragment = TextNodeType.COMPOSITE.getTextFragment();
          System.out.println("COMPOSITE: " + textFragment);
          TextNode composite = child.parse(textFragment);
          result.add(composite);
          text = text.substring(textFragment.length());
          break;
        default:
      }
    }
    return result;
  }

  @Override
  public TextNode parseFromFile() throws TextProcessingException {
    TextFileReader textFileReader = TextFileReader.getInstance();
    String text;
    try {
      text = textFileReader.read();
    } catch (IOException e) {
      throw new TextProcessingException("Cannot read from the file", e, null);
    }
    return parse(text);
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
    String textFragment;
    if (leafPattern != null) {
      Matcher leafMatcher = leafPattern.matcher(text);
      if (leafMatcher.lookingAt()) {
        textFragment = leafMatcher.group();
        TextNodeType.LEAF.setTextFragment(textFragment);
        return TextNodeType.LEAF;
      }
    }
    if (compositePattern != null) {
      Matcher compositeMatcher = compositePattern.matcher(text);
      if (compositeMatcher.lookingAt()) {
        textFragment = compositeMatcher.group();
        TextNodeType.COMPOSITE.setTextFragment(textFragment);
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

package by.pavka.wd22;

import by.pavka.wd22.entity.TextNode;

public class TextParserException extends Exception {
  private TextNode textNode;

  public TextParserException(TextNode textNode) {
    this.textNode = textNode;
  }

  public TextParserException(String message, TextNode textNode) {
    super(message);
    this.textNode = textNode;
  }

  public TextParserException(String message, Throwable cause, TextNode textNode) {
    super(message, cause);
    this.textNode = textNode;
  }

  public TextParserException(Throwable cause, TextNode textNode) {
    super(cause);
    this.textNode = textNode;
  }

  public TextNode getTextNode() {
    return textNode;
  }

  public String unhadledText() {
    return textNode.getUnhandledText();
  }
}

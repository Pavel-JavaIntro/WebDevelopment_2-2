package by.pavka.wd22.model;

import by.pavka.wd22.entity.TextNode;

public class TextProcessingException extends Exception {
  private final TextNode textNode;

  public TextProcessingException(TextNode textNode) {
    this.textNode = textNode;
  }

  public TextProcessingException(String message, TextNode textNode) {
    super(message);
    this.textNode = textNode;
  }

  public TextProcessingException(String message, Throwable cause, TextNode textNode) {
    super(message, cause);
    this.textNode = textNode;
  }

  public TextProcessingException(Throwable cause, TextNode textNode) {
    super(cause);
    this.textNode = textNode;
  }

  public TextNode getTextNode() {
    return textNode;
  }

  public String unhandledText() {
    return textNode.getUnhandledText();
  }
}

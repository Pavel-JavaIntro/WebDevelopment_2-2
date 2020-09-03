package by.pavka.wd22.model.parser;

import by.pavka.wd22.model.parser.impl.TextParserImpl;

public class PredefinedTextParserFactory {
  public static final String CODE_BLOCK = "(\\s*<code>(?s).*?</code>)";
  public static final String WORD_BLOCK = "(\\s*[\\w\"'-]+)|\\p{Punct}|( \\()";
  private static final String SENTENCE_BLOCK =
      "([\"\\d\\s]*[A-Z]{1}[\\w\\s-,:;'\"<>/{}()%=]+?[\\.\\!\\?]+)";
  private static final PredefinedTextParserFactory instance = new PredefinedTextParserFactory();
  private final TextParser parser;

  private PredefinedTextParserFactory() {
    parser = new TextParserImpl(SENTENCE_BLOCK, CODE_BLOCK);
    TextParser child = new TextParserImpl(null, WORD_BLOCK + "|" + CODE_BLOCK);
    parser.setChild(child);
  }

  public static PredefinedTextParserFactory getInstance() {
    return instance;
  }

  public TextParser getParser() {
    return parser;
  }
}

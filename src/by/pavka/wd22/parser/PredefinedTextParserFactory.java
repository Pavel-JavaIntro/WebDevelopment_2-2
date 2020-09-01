package by.pavka.wd22.parser;

public class PredefinedTextParserFactory {
  private static final PredefinedTextParserFactory instance = new PredefinedTextParserFactory();
  private static final String SENTENCE_BLOCK =
          "(\"*\\d*\\s?[A-Z]{1}[\\w\\s\\-\\,\\:\\;\\'\"\\<\\>\\/\\{\\}\\(\\)\\%\\=]+[\\.\\!\\?]+\\s*)";
  public static final String CODE_BLOCK = "\\s*<code>(?s).*?</code>";
  public static final String WORD_BLOCK = "(\\s*[\\w\"\\'\\-]+)|\\p{Punct}";

  private final TextParser parser;

  private PredefinedTextParserFactory() {
    System.out.println("FACTORY");
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

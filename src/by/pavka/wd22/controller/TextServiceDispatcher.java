package by.pavka.wd22.controller;

import by.pavka.wd22.model.service.impl.*;
import by.pavka.wd22.model.service.TextService;

import java.util.HashMap;
import java.util.Map;

public class TextServiceDispatcher {
  private static final Map<String, TextService<?, ?>> dispatcher = new HashMap<>();

  static {
    dispatcher.put("READ", new ReadTextService());
    dispatcher.put("MAX_SAME_WORD", new MaxSameWordService());
    dispatcher.put("WORD_NUMBER", new WordNumberService());
    dispatcher.put("FIRST_SENTENCE_WORD", new FirstSentenceWordService());
    dispatcher.put("INTERROGATIVE_WORD", new InterrogativeWordService());
    dispatcher.put("EXCHANGE_WORD", new ExchangeWordService());
  }

  private TextServiceDispatcher() {}

  static TextService getService(String command) {
    return dispatcher.get(command);
  }
}

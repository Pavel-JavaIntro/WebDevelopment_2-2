package by.pavka.wd22.controller;

import by.pavka.wd22.model.service.impl.FirstSentenceWordService;
import by.pavka.wd22.model.service.impl.MaxSameWordService;
import by.pavka.wd22.model.service.impl.ReadTextService;
import by.pavka.wd22.model.service.TextService;
import by.pavka.wd22.model.service.impl.WordNumberService;

import java.util.HashMap;
import java.util.Map;

public class TextServiceDispatcher {
    private final static Map<String, TextService> dispatcher = new HashMap<>();
    static {
        dispatcher.put("READ", new ReadTextService());
        dispatcher.put("MAX_SAME_WORD", new MaxSameWordService());
        dispatcher.put("WORD_NUMBER", new WordNumberService());
        dispatcher.put("FIRST_SENTENCE_WORD", new FirstSentenceWordService());
    }

    private TextServiceDispatcher() {}

    static TextService getService(String command) {
        return dispatcher.get(command);
    }
}

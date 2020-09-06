package by.pavka.wd22.controller;

import by.pavka.wd22.model.service.impl.MaxSameWordService;
import by.pavka.wd22.model.service.impl.ReadTextService;
import by.pavka.wd22.model.service.TextService;

import java.util.HashMap;
import java.util.Map;

public class TextServiceDispatcher {
    private final static Map<String, TextService> dispatcher = new HashMap<>();
    static {
        dispatcher.put("READ", new ReadTextService());
        dispatcher.put("MAXSAMEWORD", new MaxSameWordService());
    }

    private TextServiceDispatcher() {}

    static TextService getService(String command) {
        return dispatcher.get(command);
    }
}

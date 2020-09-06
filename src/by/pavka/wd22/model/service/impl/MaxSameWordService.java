package by.pavka.wd22.model.service.impl;

import by.pavka.wd22.controller.response.TextResponse;
import by.pavka.wd22.controller.response.impl.MaxSameWordResponse;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.model.service.TextService;

public class MaxSameWordService implements TextService<String, MaxSameWordService.MaxSameWord> {
    @Override
    public TextResponse<MaxSameWord> process(String data) throws TextProcessingException {
        TextNode node = constructNode(data);
        return new MaxSameWordResponse(new MaxSameWord("F", 1));
    }

    public static class MaxSameWord {
        private final String word;
        private final int repeat;

        public MaxSameWord(String word, int repeat) {
            this.word = word;
            this.repeat = repeat;
        }

        public String toText() {
            return String.format("Word %s is represented in %d sentences", word, repeat);
        }

    }
}

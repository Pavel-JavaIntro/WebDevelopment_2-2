package by.pavka.wd22.controller.request.impl;

import by.pavka.wd22.controller.request.TextRequest;

public class InterrogativeWordRequest extends TextRequest<InterrogativeWordRequest.StringAndNumber> {

    public InterrogativeWordRequest(StringAndNumber data) {
        super(data);
    }

    @Override
    public String command() {
        return "INTERROGATIVE_WORD";
    }

    public static class StringAndNumber {
        private final String input;
        private final int numberOfLetters;

        public StringAndNumber(String input, int numberOfLetters) {
            this.input = input;
            this.numberOfLetters = numberOfLetters;
        }

        public String getInput() {
            return input;
        }

        public int getNumberOfLetters() {
            return numberOfLetters;
        }
    }
}

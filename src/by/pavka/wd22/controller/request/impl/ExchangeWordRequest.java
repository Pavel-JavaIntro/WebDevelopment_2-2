package by.pavka.wd22.controller.request.impl;

import by.pavka.wd22.controller.request.TextRequest;

public class ExchangeWordRequest extends TextRequest<String> {
    public ExchangeWordRequest(String data) {
        super(data);
    }

    @Override
    public String command() {
        return "EXCHANGE_WORD";
    }
}

package by.pavka.wd22.controller.request.impl;

import by.pavka.wd22.controller.request.TextRequest;

public class ReadTextRequest extends TextRequest<String> {
    public ReadTextRequest(String data) {
        super(data);
    }

    @Override
    public String command() {
        return "READ";
    }
}

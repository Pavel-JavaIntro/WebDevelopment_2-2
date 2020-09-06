package by.pavka.wd22.controller.request.impl;

import by.pavka.wd22.controller.request.TextRequest;

public class MaxSameWordRequest extends TextRequest<String> {
    public MaxSameWordRequest(String data) {
        super(data);
    }

    @Override
    public String command() {
        return "MAXSAMEWORD";
    }
}

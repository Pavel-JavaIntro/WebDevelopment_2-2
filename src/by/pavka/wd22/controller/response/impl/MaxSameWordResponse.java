package by.pavka.wd22.controller.response.impl;

import by.pavka.wd22.controller.response.TextResponse;
import by.pavka.wd22.model.service.impl.MaxSameWordService;

public class MaxSameWordResponse extends TextResponse<MaxSameWordService.MaxSameWord> {
    public MaxSameWordResponse(MaxSameWordService.MaxSameWord result) {
        super(result);
    }

    @Override
    public String display() {
        return getResult().toText();
    }
}

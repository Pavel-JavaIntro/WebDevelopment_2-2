package by.pavka.wd22.controller.response.impl;

import by.pavka.wd22.controller.response.TextResponse;
import by.pavka.wd22.entity.TextNode;

public class ReadTextResponse extends TextResponse<TextNode> {
    public ReadTextResponse(TextNode result) {
        super(result);
    }

    @Override
    public String display() {
       return "PARSED TEXT:\n" + getResult().toText();
    }
}

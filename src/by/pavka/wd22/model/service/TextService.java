package by.pavka.wd22.model.service;

import by.pavka.wd22.controller.response.TextResponse;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.model.TextProcessingException;
import by.pavka.wd22.model.parser.PredefinedTextParserFactory;
import by.pavka.wd22.model.parser.TextParser;

public interface TextService<T, V> {
    /*
     * this main method gets data from a TextRequest and returns a TextResponse wrapping a result
     */
    TextResponse<V> process(T data) throws TextProcessingException;

    /*
     * this default method construct a TextNode from a given text, either as a String or from a file
     */
    default TextNode constructNode(String data) throws TextProcessingException {
        TextParser textParser = PredefinedTextParserFactory.getInstance().getParser();
        TextNode result;
        if (data == null) {
            result = textParser.parseFromFile();
        } else {
            result = textParser.parse(data);
        }
        return result;
    }
}

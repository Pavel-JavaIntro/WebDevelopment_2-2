package by.pavka.wd22.controller.response;

public abstract class TextResponse<T> {

    private final T result;

    public TextResponse(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public abstract String display();
}

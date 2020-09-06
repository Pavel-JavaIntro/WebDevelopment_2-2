package by.pavka.wd22.controller.request;

public abstract class TextRequest<T> {
    private final T data;

    public TextRequest(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public abstract String command();
}

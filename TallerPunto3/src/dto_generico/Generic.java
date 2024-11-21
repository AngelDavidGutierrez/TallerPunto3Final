package dto_generico;

public class Generic<T> {

    private T content;

    public Generic() {
        this.content = null;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

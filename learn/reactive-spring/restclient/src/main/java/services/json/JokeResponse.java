package services.json;

public class JokeResponse {
    private String type;
    private JokeValue value;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JokeValue getValue() {
        return value;
    }

    public void setValue(JokeValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "JokeResponse{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}

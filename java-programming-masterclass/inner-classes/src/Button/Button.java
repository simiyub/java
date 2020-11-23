package Button;

public class Button {
    private Button.OnClickListener onClickListener;
    private String title;
    public Button(String title){
        this.title=title;
    }

    public OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public String getTitle() {
        return title;
    }

    public void onClick() {
        this.onClickListener.onClick(this.title);
    }


    public interface OnClickListener {
        void onClick(String title);

    }
}

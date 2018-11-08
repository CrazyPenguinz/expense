import javafx.collections.ObservableList;

public interface Connectable {
    ObservableList<Information> viewHistory();
    void add(String type, String detail, String amount);
}

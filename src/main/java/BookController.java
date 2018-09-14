import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Created by 708 on 9/14/2018.
 */
public class BookController {
    @FXML private TextArea textArea;
    @FXML private Button editButton, addButton, viewHistoryButton;

    public void initialize() {
        textArea.setEditable(true);
        textArea.setText("");
        editButton.setDisable(true);
    }

    public void editBtnOnAction(ActionEvent event) {
        textArea.setEditable(true);
        String[] tmp = textArea.getText().split("\n");
        BookFileConnector.edit(tmp);
        textArea.setEditable(false);
        textArea.setText("");
        editButton.setDisable(true);
    }

    public void addBtnOnAction(ActionEvent event) {
        BookFileConnector.add(textArea.getText());
        textArea.clear();
    }

    public void viewHistoryBtnOnAction(ActionEvent event) {
        textArea.setText(viewHistory());
        editButton.setDisable(false);
    }

    private String viewHistory() {
        String tmp = "";
        for (String s : BookFileConnector.viewHistory())
            tmp += s;
        return tmp;
    }
}

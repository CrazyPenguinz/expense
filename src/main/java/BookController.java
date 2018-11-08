import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by 708 on 9/14/2018.
 */
public class BookController {
    @FXML private TextField describe, amt;
    @FXML private Button addButton, totalButton;
    @FXML private ChoiceBox<String> type;
    @FXML private TableView<Information> tableView;
    @FXML private TableColumn detail, amount;
    @FXML private Label label;

    public void initialize() {
        detail.setCellValueFactory(new PropertyValueFactory<Information, String>("detail"));
        amount.setCellValueFactory(new PropertyValueFactory<Information, String>("amount"));
        tableView.setItems(BookFileConnector.viewHistory());
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Information>() {
            @Override
            public void changed(ObservableValue<? extends Information> observable, Information oldValue, Information newValue) {
                addButton.setDisable(false);
            }
        });
        describe.setText("");
        type.getItems().addAll("Income", "Expense");

    }

    public void addBtnOnAction(ActionEvent event) {
        String t  = type.getValue();
        String des  = describe.getText();
        String am = amt.getText();
        if (t != null && des != null && am != null) {
            if (t.equals("Income"))
                BookFileConnector.add(t + " " + des + " +" + am);
            else if (t.equals("Expense"))
                BookFileConnector.add(t + " " + des + " -" + am);
            describe.clear();
            amt.clear();
            tableView.setItems(BookFileConnector.viewHistory());
        }
    }

    public void showTotal(ActionEvent event) {
        double total = 0;
        for (Information i : BookFileConnector.viewHistory()) {
            if (i.getType().equals("Income"))
                total += Double.valueOf(i.getAmount().substring(1));
            else if (i.getType().equals("Expense"))
                total -= Double.valueOf(i.getAmount().substring(1));
        }
        label.setText("Total : " + total);
    }

}

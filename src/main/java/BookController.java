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
    private Connectable connector;

    @FXML private TextField describe, amt;
    @FXML private Button addButton, totalButton, swButton;
    @FXML private ChoiceBox<String> type;
    @FXML private TableView<Information> tableView;
    @FXML private TableColumn detail, amount;
    @FXML private Label label;


    public void initialize() {
        connector = BookDBConnector.getInstance();
        detail.setCellValueFactory(new PropertyValueFactory<Information, String>("detail"));
        amount.setCellValueFactory(new PropertyValueFactory<Information, String>("amount"));
        tableView.setItems(connector.viewHistory());
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
                connector.add(t, des, "+" + am);
            else if (t.equals("Expense"))
                connector.add(t, des, "-" + am);
            describe.clear();
            amt.clear();
            tableView.setItems(connector.viewHistory());
        }
    }

    public void showTotal(ActionEvent event) {
        double total = 0;
        for (Information i : connector.viewHistory()) {
            if (i.getType().equals("Income"))
                total += Double.valueOf(i.getAmount().substring(1));
            else if (i.getType().equals("Expense"))
                total -= Double.valueOf(i.getAmount().substring(1));
        }
        label.setText("Total : " + total);
    }

    public void switchDB() {
        if (BookDBConnector.class == connector.getClass()) {
            connector = BookFileConnector.getInstance();
        }
        else {
            connector = BookDBConnector.getInstance();
        }
        tableView.setItems(connector.viewHistory());
    }

}

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public class SearchController implements Controller{
    public SearchView searchView;
    private EmployeeList employeeList;

    public SearchController(EmployeeList employeeList, SearchView searchView) {
        this.employeeList = employeeList;
        this.searchView = searchView;
        this.searchView.getSearchButton().addActionListener(e -> confirm());
        this.searchView.getClearButton().addActionListener(e -> clear());
    }

    @Override
    public void confirm() {
        JTextArea resultsTextArea = searchView.getResultsTextArea();
        resultsTextArea.setText("");
        String field = (String) searchView.getSearchComboBox().getSelectedItem();
        String value_str = searchView.getSearchTextField().getText();

        if (field == null) {
            JOptionPane.showMessageDialog(null,
                    "Please select a search field!",
                    "Invalid field",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        switch (field) {
            case "ID" : {
                try {
                    int ID = Integer.parseInt(value_str);
                    Optional<Employee> results = employeeList.findByID(ID);
                    if (results.isPresent()) {
                        resultsTextArea.setText(results.get().toString());
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a valid ID!",
                            "Invalid ID",
                            JOptionPane.ERROR_MESSAGE);
                }
                break;
            }

            case "Name" : {
                List<Employee> results = employeeList.findByName(value_str);
                results.forEach(result -> {
                    resultsTextArea.append(result.toString());
                });
                break;
            }

            case "Age" : {
                try {
                    int age = Integer.parseInt(value_str);
                    List<Employee> results = employeeList.findByAge(age);
                    results.forEach(result -> {
                        resultsTextArea.append(result.toString());
                    });
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a valid age!",
                            "Invalid age",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            }

            case "Position" : {
                List<Employee> results = employeeList.findByPosition(value_str);
                results.forEach(result -> {
                    resultsTextArea.append(result.toString());
                });
                break;
            }
        }
    }

    @Override
    public void clear() {
        searchView.getSearchComboBox().setSelectedItem(null);
        searchView.getResultsTextArea().setText("");
        searchView.getSearchTextField().setText("");
    }
}

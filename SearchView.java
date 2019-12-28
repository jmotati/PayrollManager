import javax.swing.*;

public class SearchView {
    private JPanel mainPanel;
    private JComboBox searchComboBox;
    private JTextField searchTextField;
    private JButton searchButton;
    private JButton clearButton;
    private JTextArea resultsTextArea;

    public SearchView() {

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JComboBox getSearchComboBox() {
        return searchComboBox;
    }

    public JTextField getSearchTextField() {
        return searchTextField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JTextArea getResultsTextArea() {
        return resultsTextArea;
    }
}

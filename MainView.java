import javax.swing.*;

public class MainView {
    private JPanel mainPanel;
    private JTabbedPane mainTabbedPane;

    private HireView hireView;
    private PayView payView;
    private SearchView searchView;

    public MainView() {
        this.hireView = new HireView();
        this.payView = new PayView();
        this.searchView = new SearchView();

        this.mainTabbedPane.add("Hire", hireView.getMainPanel());
        this.mainTabbedPane.add("Pay", payView.getMainPanel());
        this.mainTabbedPane.add("Search", searchView.getMainPanel());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTabbedPane getMainTabbedPane() {
        return mainTabbedPane;
    }

    public HireView getHireView() {
        return hireView;
    }

    public PayView getPayView() {
        return payView;
    }

    public SearchView getSearchView() {
        return searchView;
    }
}

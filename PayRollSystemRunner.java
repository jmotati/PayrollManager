import javax.swing.*;
import java.math.BigDecimal;

public class PayRollSystemRunner {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();

            return;
        }
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Product Inventory");
            EmployeeList employeeList = new EmployeeList();
            MainView mainView = new MainView();

            new HireController(employeeList, mainView.getHireView());

            new PayController(employeeList, mainView.getPayView());

            new SearchController(employeeList, mainView.getSearchView());

            frame.setContentPane(mainView.getMainPanel());

            frame.pack();

            frame.setLocationRelativeTo(null);

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            frame.setVisible(true);
        });
    }
}

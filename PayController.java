import javax.swing.*;
import java.util.Optional;

public class PayController implements Controller{
    private PayView payView;
    private EmployeeList employeeList;

    public PayController(EmployeeList employeeList, PayView payView) {
        this.employeeList = employeeList;
        this.payView = payView;
        this.payView.getPayButton().addActionListener(e -> confirm());
        this.payView.getClearButton().addActionListener(e -> clear());
    }

    @Override
    public void confirm() {
        String ID_str = payView.getIdTextField().getText();
        String raise_str = payView.getRaiseTextField().getText();
        int id = -1;
        int raise = -1;

        try {
            id = Integer.parseInt(ID_str);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Please enter a valid ID!",
                    "Invalid ID",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            raise = Integer.parseInt(raise_str);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Please enter a valid raise amount!",
                    "Invalid raise",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Optional<Employee> employee = employeeList.findByID(id);
        if (employee.isPresent()) {
            employee.get().setRaise(raise);
            employee.get().pay();
            JOptionPane.showMessageDialog(null,
                    "The employee has been paid!",
                    "Pay successful",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No employee with the specified ID exist!",
                    "Invalid ID",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void clear() {
        payView.getIdTextField().setText("");
        payView.getRaiseTextField().setText("");
    }
}

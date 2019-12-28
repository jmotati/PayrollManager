import javax.swing.*;
import java.awt.event.MouseListener;

public class HireController implements Controller{
    private HireView hireView;

    private EmployeeList employeeList;

    public HireController(EmployeeList employeeList, HireView hireView) {
        this.employeeList = employeeList;
        this.hireView = hireView;
        this.hireView.getHireButton().addActionListener(e -> confirm());
        this.hireView.getClearButton().addActionListener(e -> clear());
        this.hireView.getPositionComboBox().addActionListener(e -> change());
        clear();
        change();
    }

    @Override
    public void confirm() {
        String ID_str = hireView.getIdTextField().getText();
        int id = -1;
        String name = hireView.getNameTextField().getText();
        String position = (String) hireView.getPositionComboBox().getSelectedItem();
        String department = hireView.getDepartmentTextField().getText();
        String speciality = hireView.getSpecialityTextField().getText();
        String age_str = hireView.getAgeTextField().getText();
        int age = -1;
        String managerID_str = hireView.getManagerTextField().getText();
        int managerID = -1;

        if (position == null) {
            JOptionPane.showMessageDialog(null,
                    "Please choose a position!",
                    "Invalid position",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            id = Integer.parseInt(ID_str);
            if (employeeList.findByID(id).isPresent()) {
                JOptionPane.showMessageDialog(null,
                        "An employee with the same ID already exists!",
                        "Invalid ID!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Please enter a valid ID!",
                    "Invalid ID!",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            age =  Integer.parseInt(age_str);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Please enter a valid age!",
                    "Invalid age",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!managerID_str.equals("")) {
            try {
                managerID = Integer.parseInt(managerID_str);
                if (employeeList.findByID(managerID).equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "The manager ID does not exist in our system!",
                            "Invalid manager ID",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid manger ID!",
                        "Invalid manager ID",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }


        Employee employee = null;

        Employee manager = null;
        if (managerID != -1) {
            manager = employeeList.findByID(managerID).get();
        }

        switch (position) {
            case "Manager" : {
                if (department == null) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a department!",
                            "Invalid department",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                employee = new Manager(id, manager, name, age, department);
                break;
            }

            case "IT" : {
                employee = new IT(id, manager, name, age, speciality);
                break;
            }

            case "Waiter" : {
                employee = new Waiter(id, manager, name, age);
                break;
            }

            case "Cashier" : {
                employee = new Cashier(id, manager, name, age);
                break;
            }

            default : {
                JOptionPane.showMessageDialog(null,
                        "Invalid position",
                        "Invalid position",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (employee != null) {
            employeeList.add(employee);
            JOptionPane.showMessageDialog(null,
                    "The employee has been hired!",
                    "Hire successful",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void clear() {
        hireView.getIdTextField().setText("");
        hireView.getNameTextField().setText("");
        hireView.getAgeTextField().setText("");
        hireView.getDepartmentTextField().setText("");
        hireView.getSpecialityTextField().setText("");
        hireView.getManagerTextField().setText("");
    }

    public void change() {
        String position = (String) hireView.getPositionComboBox().getSelectedItem();
        hireView.getDepartmentPanel().setVisible(false);
        hireView.getSpecialityPanel().setVisible(false);
        if (position != null) {
            switch(position) {
                case "Manager" :
                    hireView.getDepartmentPanel().setVisible(true);
                    break;
                case "IT" :
                    hireView.getSpecialityPanel().setVisible(true);
                    break;
            }
        }
    }
}

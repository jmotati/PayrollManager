import javax.swing.*;

public class HireView {
    private JPanel mainPanel;
    private JTextField nameTextField;
    private JComboBox positionComboBox;
    private JTextField ageTextField;
    private JTextField managerTextField;
    private JButton hireButton;
    private JButton clearButton;
    private JTextField idTextField;
    private JTextField departmentTextField;
    private JPanel departmentPanel;
    private JTextField specialityTextField;
    private JPanel specialityPanel;

    public HireView() {

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JComboBox getPositionComboBox() {
        return positionComboBox;
    }

    public JTextField getAgeTextField() {
        return ageTextField;
    }

    public JTextField getManagerTextField() {
        return managerTextField;
    }

    public JButton getHireButton() {
        return hireButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JTextField getDepartmentTextField() {
        return departmentTextField;
    }

    public JPanel getDepartmentPanel() {
        return departmentPanel;
    }

    public JTextField getSpecialityTextField() {
        return specialityTextField;
    }

    public JPanel getSpecialityPanel() {
        return specialityPanel;
    }
}

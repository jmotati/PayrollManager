public class Manager extends SalariedEmployee {
    private String department;

    public Manager(int ID, Employee manager, String name, int age, String department) {
        super(ID, manager, name, age);
        this.department = department;
        setBaseSalary(10000);
        setRaise(0);
    }

    @Override
    public String getPosition() {
        return "Manager";
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format(
                "Manager: %s\n" +
                        "ID: %d\n" +
                        "Age: %d\n" +
                        "Department: %s\n" +
                        "Balance: %.2f\n\n",
                getName(), getID(), getAge(), getDepartment(), getBalance());
    }

}

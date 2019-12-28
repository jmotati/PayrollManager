public class Cashier extends HourlyEmployee {
    public Cashier(int ID, Employee manager, String name, int age) {
        super(ID, manager, name, age);
        setBaseSalary(100);
    }

    @Override
    public String getPosition() {
        return "Cashier";
    }

    @Override
    public String toString() {
        return String.format(
                "Cashier: %s\n" +
                        "ID: %d\n" +
                        "Age: %d\n" +
                        "Balance: %.2f\n\n",
                getName(), getID(), getAge(), getBalance());
    }
}

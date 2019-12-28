public abstract class SalariedEmployee implements Employee{
    private int ID;
    private Employee manager;
    private String name;
    private int age;
    private double baseSalary;
    private double raise;
    private double balance;

    public SalariedEmployee(int ID, Employee manager, String name, int age) {
        this.ID = ID;
        this.manager = manager;
        this.name = name;
        this.age = age;
        this.baseSalary = baseSalary;
        this.raise = raise;
        this.balance = 0;
    }

    @Override
    public void pay() {
        this.balance += this.baseSalary + this.raise;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getRaise() {
        return raise;
    }

    public void setRaise(double raise) {
        this.raise = raise;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

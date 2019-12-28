public class IT extends SalariedEmployee {
    String speciality;

    public IT(int ID, Employee manager, String name, int age, String speciality) {
        super(ID, manager, name, age);
        setBaseSalary(10000);
        setRaise(0);
        this.speciality = speciality;
    }

    @Override
    public String getPosition() {
        return "IT";
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return String.format(
                "IT: %s\n" +
                        "ID: %d\n" +
                        "Age: %d\n" +
                        "Speciality: %s\n" +
                        "Balance: %.2f\n\n",
                getName(), getID(), getAge(), getSpeciality(), getBalance());
    }
}

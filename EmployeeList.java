import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeList {
    private List<Employee> employeeList;

    public EmployeeList() {
        employeeList = new ArrayList<>();
    }

    public void add(Employee employee) {
        employeeList.add(employee);
    }

    public Optional<Employee> findByID(int ID) {
        return this.employeeList.stream()
                .filter(employee -> (employee.getID() == ID))
                .findAny();
    }

    public List<Employee> findByName(String name) {
        return this.employeeList.stream()
                .filter(employee -> (employee.getName().equalsIgnoreCase(name)))
                .collect(Collectors.toList());
    }

    public List<Employee> findByAge(int age) {
        return this.employeeList.stream()
                .filter(employee -> (employee.getAge() == age))
                .collect(Collectors.toList());
    }

    public List<Employee> findByPosition(String position) {
        return this.employeeList.stream()
                .filter(employee -> (employee.getPosition().equalsIgnoreCase(position)))
                .collect(Collectors.toList());
    }
}

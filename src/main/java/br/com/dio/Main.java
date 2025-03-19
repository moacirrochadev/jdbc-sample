package br.com.dio;

import br.com.dio.persistence.EmployeeDAO;
import br.com.dio.persistence.entity.EmployeeEntity;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Main {
    private final static EmployeeDAO employeeDAO = new EmployeeDAO();

    public static void main(String[] args) {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/jdbc_sample", "root", "root")
                .load();

        flyway.migrate();


//        var employee = new EmployeeEntity();
//        employee.setName("Neto");
//        employee.setSalary(new BigDecimal("1512.00"));
//        employee.setBirthday(OffsetDateTime.now().minusYears(42));
//        System.out.println(employee);
//        employeeDAO.insert(employee);
//        System.out.println(employee);
//
//        employeeDAO.findAll().forEach(System.out::println);
//
//        System.out.println(employeeDAO.findById(3));

//        var employee = new EmployeeEntity();
//        employee.setId(3);
//        employee.setName("Thal");
//        employee.setSalary(new BigDecimal("2512.00"));
//        employee.setBirthday(OffsetDateTime.now().minusYears(42));
//        employeeDAO.update(employee);
//
//        employeeDAO.delete(1);

    }
}

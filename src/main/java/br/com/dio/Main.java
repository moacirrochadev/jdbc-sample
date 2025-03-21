package br.com.dio;

import br.com.dio.persistence.EmployeeAuditDAO;
import br.com.dio.persistence.EmployeeDAO;
import br.com.dio.persistence.EmployeeParamDAO;
import br.com.dio.persistence.entity.EmployeeEntity;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Locale;
import java.util.stream.Stream;

import static java.time.ZoneOffset.UTC;

public class Main {
    private final static EmployeeParamDAO employeeDAO = new EmployeeParamDAO();
    private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();
    private final static Faker faker = new Faker(Locale.of("pt", "BR"));

    public static void main(String[] args) {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/jdbc_sample", "root", "root")
                .load();

        flyway.migrate();


        /*var insert = new EmployeeEntity();
        insert.setName("Wandinha'");
        insert.setSalary(new BigDecimal("5500.00"));
        insert.setBirthday(OffsetDateTime.now().minusYears(25));
        System.out.println(insert);
        employeeDAO.insertWithProcedure(insert);
        System.out.println(insert);*/
//
//        employeeDAO.findAll().forEach(System.out::println);
//
//        System.out.println(employeeDAO.findById(3));

        /*var update = new EmployeeEntity();
        update.setId(insert.getId());
        update.setName("Thal");
        update.setSalary(new BigDecimal("10500.00"));
        update.setBirthday(OffsetDateTime.now().minusYears(42));
        employeeDAO.update(update);

        employeeDAO.delete(insert.getId());

        employeeAuditDAO.findAll().forEach(System.out::println);*/

        var entities = Stream.generate(() -> {
            var employee = new EmployeeEntity();
            employee.setName(faker.name().fullName());
            employee.setSalary(new BigDecimal(faker.number().digits(4)));
            employee.setBirthday(OffsetDateTime.of(LocalDate.now().minusYears(faker.number().numberBetween(40, 20)), LocalTime.MIN, UTC));
            return employee;
        }).limit(10000).toList();

        employeeDAO.insert(entities);
    }
}

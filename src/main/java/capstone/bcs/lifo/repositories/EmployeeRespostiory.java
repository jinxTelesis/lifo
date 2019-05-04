package capstone.bcs.lifo.repositories;

import capstone.bcs.lifo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespostiory extends JpaRepository<Employee,Long> {

}

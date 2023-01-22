package mk.ukim.finki.wp.kol2022.g1.repository;

import mk.ukim.finki.wp.kol2022.g1.model.Employee;
import mk.ukim.finki.wp.kol2022.g1.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

//    List<Employee> findAllBySkillIdAndYerarsOfService(Skill skill, Integer yearsOfService);
//    List<Employee> findAllBySkillId(Skill skill);
//    List<Employee> findAllByYerarsOfService(Integer yearsOfService);
}

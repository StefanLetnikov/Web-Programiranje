package mk.ukim.finki.wp.kol2022.g1.service.Impl;

import mk.ukim.finki.wp.kol2022.g1.model.Employee;
import mk.ukim.finki.wp.kol2022.g1.model.EmployeeType;
import mk.ukim.finki.wp.kol2022.g1.model.Skill;
import mk.ukim.finki.wp.kol2022.g1.model.exceptions.InvalidEmployeeIdException;
import mk.ukim.finki.wp.kol2022.g1.repository.EmployeeRepository;
import mk.ukim.finki.wp.kol2022.g1.repository.SkillRepository;
import mk.ukim.finki.wp.kol2022.g1.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final SkillRepository skillRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, SkillRepository skillRepository) {
        this.employeeRepository = employeeRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public List<Employee> listAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return this.employeeRepository.findById(id).orElseThrow(InvalidEmployeeIdException::new);
    }

    @Override
    public Employee create(String name, String email, String password, EmployeeType type, List<Long> skillId, LocalDate employmentDate) {
        List<Skill> skills = this.skillRepository.findAllById(skillId);
        Employee employee = new Employee(name,email,password,type,skills,employmentDate);
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, String name, String email, String password, EmployeeType type, List<Long> skillId, LocalDate employmentDate) {
        Employee employee = this.findById(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setPassword(password);
        employee.setType(type);
        List<Skill> skills = this.skillRepository.findAllById(skillId);
        employee.setSkills(skills);
        employee.setEmploymentDate(employmentDate);
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee delete(Long id) {
        Employee employee = this.findById(id);
        this.employeeRepository.delete(employee);
        return employee;
    }

    @Override
    public List<Employee> filter(Long skillId, Integer yearsOfService) {
//        Skill skills = skillId  != null ? this.skillRepository.findById(skillId).orElse((Skill) null) :null;
//        if(skills != null && yearsOfService != null){
//            return this.employeeRepository.findAllBySkillIdAndYerarsOfService(skills,yearsOfService);
//        }
//        else if (skills != null){
//            return this.employeeRepository.findAllBySkillId(skills);
//        }
//        else if (yearsOfService != null){
//            return this.employeeRepository.findAllByYerarsOfService(yearsOfService);
//        }
//        else{
//            return this.employeeRepository.findAll();
//        }
        return new ArrayList<>();
    }
}

package com.isep.testjpa.controller;
import com.isep.testjpa.repository.EmpRepository;
import com.isep.testjpa.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SimpleController {
    @Autowired
    private EmpRepository empRepository;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String hello(@Param("name") String name) {
        return "Hello " + name;
    }
    @RequestMapping(value="/employees", method= RequestMethod.GET)
    public List<Emp> getEmployees() {
        return empRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Emp> getEmployeeById(@PathVariable Long id) {
        return empRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(value="/employees")
    public Emp addEmployee(@RequestBody Emp emp) {
        return empRepository.save(emp);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Emp> updateEmployee(@PathVariable Long id, @RequestBody Emp empDetails) {
        return empRepository.findById(id)
                .map(emp -> {

                    emp.setEname(empDetails.getEname());

                    Emp updatedEmp = empRepository.save(emp);
                    return ResponseEntity.ok(updatedEmp);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Optional<Emp> empOptional = empRepository.findById(id);
        if (empOptional.isPresent()) {
            empRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

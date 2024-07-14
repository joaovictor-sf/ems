package org.joaovictor.emsbackend.controller;

import lombok.AllArgsConstructor;
import org.joaovictor.emsbackend.dto.EmployeeDTO;
import org.joaovictor.emsbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {

        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id) {

        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO employeeDTO) {

        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }
}

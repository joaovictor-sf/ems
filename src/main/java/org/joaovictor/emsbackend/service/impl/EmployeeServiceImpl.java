package org.joaovictor.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import org.joaovictor.emsbackend.dto.EmployeeDTO;
import org.joaovictor.emsbackend.entity.Employee;
import org.joaovictor.emsbackend.exception.ResourceNotFoundException;
import org.joaovictor.emsbackend.mapper.EmployeeMapper;
import org.joaovictor.emsbackend.repository.EmploeeRepository;
import org.joaovictor.emsbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmploeeRepository repository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = repository.save(employee);

        return EmployeeMapper.toDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        return EmployeeMapper.toDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = repository.findAll();

        return EmployeeMapper.toDTOList(employees);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());

        Employee updatedEmployee = repository.save(employee);

        return EmployeeMapper.toDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        repository.deleteById(id);
    }
}

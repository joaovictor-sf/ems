package org.joaovictor.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import org.joaovictor.emsbackend.dto.EmployeeDTO;
import org.joaovictor.emsbackend.entity.Employee;
import org.joaovictor.emsbackend.exception.ResourceNotFoundException;
import org.joaovictor.emsbackend.mapper.EmployeeMapper;
import org.joaovictor.emsbackend.repository.EmploeeRepository;
import org.joaovictor.emsbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

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
}

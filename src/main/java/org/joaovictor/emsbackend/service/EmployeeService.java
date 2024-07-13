package org.joaovictor.emsbackend.service;

import org.joaovictor.emsbackend.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long id);
}

package org.joaovictor.emsbackend.mapper;

import org.joaovictor.emsbackend.dto.EmployeeDTO;
import org.joaovictor.emsbackend.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
    }

    public static Employee toEntity(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getId(), employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmail());
    }

    public static List<EmployeeDTO> toDTOList(List<Employee> employees) {
        return employees.stream().map(EmployeeMapper::toDTO).collect(Collectors.toList());
    }
}

package org.joaovictor.emsbackend.repository;

import org.joaovictor.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploeeRepository extends JpaRepository<Employee, Long> {
}

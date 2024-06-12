package com.devsuperior.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.demo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// JPQL
	// JOIN FETCH  Buscar o Funcionário com as Departamento associadas, List<>
	//resolvendo o problema consulta N+1
	@Query(value = "SELECT obj FROM Employee obj JOIN FETCH obj.department")  // department - atributo da classe
	List<Employee> searchAll();

	// JPQL
	// JOIN FETCH  Buscar o Funcionário com as Departamento associadas, Paginado obrigado colocar countQuery
	// com paginação
	@Query(value = "SELECT obj FROM Employee obj JOIN FETCH obj.department",
			countQuery = "SELECT COUNT(obj) FROM Employee obj JOIN obj.department")
	Page<Employee> searchAll(Pageable pageable);
}

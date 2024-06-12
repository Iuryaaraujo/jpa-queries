package com.devsuperior.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	// JPQL
	// JOIN FETCH  Buscar o Produtor com as Categorias associadas, List<>
	//resolvendo o problema consulta N+1
	@Query(value = "SELECT obj FROM Product obj JOIN FETCH obj.categories") // categories - atributo da classe
	List<Product> searchAll();
}

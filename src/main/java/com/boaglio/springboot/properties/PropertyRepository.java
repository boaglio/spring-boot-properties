package com.boaglio.springboot.properties;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

 

public interface PropertyRepository extends PagingAndSortingRepository<Property, String> {   

	 
	public List<Property> findByName(String name);
	
	
	@Query("Select c from Property c where c.name like %:filtro% order by category, subcategory, name")
	public List<Property> findByFiltro(@Param("filtro") String filtro);
	
}

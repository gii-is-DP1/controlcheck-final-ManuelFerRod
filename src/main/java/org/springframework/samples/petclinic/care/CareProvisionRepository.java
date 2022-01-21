package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CareProvisionRepository extends CrudRepository<CareProvision, Integer>{
    
	@Query("SELECT CP FROM careProvision")
	List<CareProvision> findAll();
	
	@Query("SELECT CP FROM careProvision WHERE CP.id=?1")
    Optional<CareProvision> findById(int id);
	
    CareProvision save(CareProvision p);
    
    @Query("SELECT C FROM cares")
	List<Care> findAllCares();
    
    
    //List<Care> findCompatibleCares(String petTypeName);
    //Care findCareByName(String name);
    //List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
}

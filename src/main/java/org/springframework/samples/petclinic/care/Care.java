package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cares")
public class Care extends NamedEntity{
	
	@Column(name="name", unique=true)
	@NotEmpty
	@Size(min=3,max=50)
    String name;
	
	@Column(name="description")
	@NotEmpty
    String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "care_types", joinColumns = @JoinColumn(name = "care_id"),
			inverseJoinColumns = @JoinColumn(name = "type_id"))
    Set<PetType> compatiblePetTypes;
}

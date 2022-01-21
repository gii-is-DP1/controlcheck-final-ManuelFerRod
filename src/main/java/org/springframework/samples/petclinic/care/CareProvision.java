package org.springframework.samples.petclinic.care;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="careProvision")
public class CareProvision extends NamedEntity{   
	
	@Column(name="duration")
	@Min(0)
    double duration;
    
    @ManyToOne
    @Column(name="visit")
    @JoinColumn(name="visit_id")
    Visit visit;
    
	@ManyToOne
	@NotNull
	@Column(name="care")
	@JoinColumn(name = "care_id")
    Care care;   
}

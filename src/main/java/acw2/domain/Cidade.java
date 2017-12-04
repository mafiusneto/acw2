package acw2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name="cidade")
@Data
public class Cidade extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long geonameId;
	
	private String name;
	
	private Long population;
	
	private String adminName1; //Paraíba
	
	private String countryName; //Brazil
	
	private String lng;
	
	private String lat;
}

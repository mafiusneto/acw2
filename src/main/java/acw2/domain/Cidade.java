package acw2.domain;

import javax.persistence.Column;
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
	
	private String cidade;
	
	private Long habitantes;
	
	private String estado;
	
	@Column(length=2)
	private String uf;
}

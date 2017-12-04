package acw2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import acw2.domain.Candidatura;

@Repository
public interface CandidaturaRepository extends CrudRepository<Candidatura, Long>{

	@Query("select c from candidatura c where c.id_politico = ?1")
	public List<Candidatura> findByIdPolitico(Long id_politico);

	@Query("select c from candidatura c where c.id_cidade = ?1")
	public List<Candidatura> findByIdCidade(Long id_cidade);
	

	@Query("select c from candidatura c where c.id_politico = ?1 and c.id_cidade = ?2")
	public List<Candidatura> findByPolitico_Cidade(Long id_politico, Long id_cidade);
}

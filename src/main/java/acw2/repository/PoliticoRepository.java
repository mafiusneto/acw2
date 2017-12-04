package acw2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import acw2.domain.Politico;

@Repository
public interface PoliticoRepository  extends CrudRepository<Politico, Long>{

	public Politico findByNome(String nome);
}

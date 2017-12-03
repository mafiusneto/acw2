package acw2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import acw2.domain.Politico;

@Repository
public interface PoliticoRepository  extends CrudRepository<Politico, Long>{

}

package acw2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import acw2.domain.Candidatura;

@Repository
public interface CandidaturaRepository extends CrudRepository<Candidatura, Long>{

}

package acw2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import acw2.domain.Cidade;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Long>{

}

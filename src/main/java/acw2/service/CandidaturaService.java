package acw2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acw2.domain.Candidatura;
import acw2.repository.CandidaturaRepository;

@Service
public class CandidaturaService extends AbstractService<Candidatura>{
	
	@Autowired
	private CandidaturaRepository repository;

	public List<Candidatura> list() {
		return  (List<Candidatura>) repository.findAll();
	}
	
	public Candidatura getById(Long id){
		return (Candidatura) repository.findOne(id);
	}
	
	public List<Candidatura> findByIdPolitico(Long id_politico) {
		return  (List<Candidatura>) repository.findByIdPolitico(id_politico);
	}
	
	public List<Candidatura> findByIdCidade(Long id_cidade) {
		return  (List<Candidatura>) repository.findByIdCidade(id_cidade);
	}
	
	public List<Candidatura> findByPolitico_Cidade(Long id_politico, Long id_cidade) {
		return  (List<Candidatura>) repository.findByPolitico_Cidade(id_politico, id_cidade);
	}
	
	public Long save(Candidatura curso){
		Candidatura obj = null;
		obj = repository.save(curso);
		if (obj != null){ 
			return obj.getId();
		}else{
			return 0L;
		}
	}
	
	public void delete(Long id){
		repository.delete(id);
	}
	
	public List<Candidatura> finds(List<Long> ids) {
		return  (List<Candidatura>) repository.findAll(ids);
	}
	
	
}

package acw2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acw2.domain.Politico;
import acw2.repository.PoliticoRepository;

@Service
public class PoliticoService extends AbstractService<Politico>{
	
	@Autowired
	private PoliticoRepository repository;
	
	public List<Politico> list() {
		return  (List<Politico>) repository.findAll();
	}
	
	public Politico getById(Long id){
		return (Politico) repository.findOne(id);
	}
	
	public Politico getByNome(String nome){
		return (Politico) repository.findByNome(nome);
	}
	
	public Long save(Politico politico){
		Politico obj = null;
		obj = repository.save(politico);
		if (obj != null){ 
			return obj.getId();
		}else{
			return 0L;
		}
	}
	
	public void delete(Long id){
		repository.delete(id);
	}
	
	public List<Politico> finds(List<Long> ids) {
		return  (List<Politico>) repository.findAll(ids);
	}
	
}

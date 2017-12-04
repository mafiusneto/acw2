package acw2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import acw2.domain.Politico;
import acw2.service.PoliticoService;

@RestController
@RequestMapping("politico")
public class PoliticoController {

	@Autowired
	private PoliticoService service; 
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Politico> lista() {
		Iterable<Politico> politicos = service.list();
		return politicos;
	}
	
	@PostMapping()
	public Long cadastrarPolitico(@RequestBody @Valid Politico politico) {
		return service.save(politico);
	}
	
	@PutMapping()
	public Long alterarPolitico(@RequestBody @Valid Politico politico) {
		if (politico.getId() == 0){
			return 0L;
		}else{
			Politico p = service.getById(politico.getId());
			if (p == null){
				return 0L;
			}
		}
		
		return service.save(politico);
	}
	
	@DeleteMapping(value="/{id}")
	public Long deletaPolitico(@PathVariable Long id) {
		try {
			service.delete(id);
			return id;			
		} catch (Exception e) {
			return 0L;
		}
	}
	/*
	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody Politico getById(@PathVariable long id) {
		System.out.println("getById");
		Politico politico = service.getById(id);
		return politico;
	}
	*/
	@GetMapping(value="/{nome}", produces="application/json")
	public @ResponseBody Iterable<Politico> getByNome(@PathVariable String nome) {
		//System.out.println("getByNome");
		Iterable<Politico> politicos = service.getByNome(nome);
		return politicos;
	}
	
}

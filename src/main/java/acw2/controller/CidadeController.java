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

import acw2.domain.Cidade;
import acw2.domain.Politico;
import acw2.service.CidadeService;

@RestController
@RequestMapping("cidade")
public class CidadeController {

	@Autowired
	private CidadeService service; 
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Cidade> lista() {
		Iterable<Cidade> cidades = service.list();
		return cidades;
	}
	
	@PostMapping()
	public Long cadastrarCidade(@RequestBody @Valid Cidade cidade) {
		return service.save(cidade);
	}
	
	@PutMapping()
	public Long alterarCidade(@RequestBody @Valid Cidade cidade) {
		if (cidade.getId() == 0){
			return 0L;
		}else{
			Cidade p = service.getById(cidade.getId());
			if (p == null){
				return 0L;
			}
		}
		return service.save(cidade);
	}
	
	@DeleteMapping(value="/{id}")
	public Long deletaCidade(@PathVariable Long id) {
		try {
			service.delete(id);
			return id;			
		} catch (Exception e) {
			return 0L;
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody Cidade getById(@PathVariable long id) {
		Cidade cidade = service.getById(id);
		return cidade;
	}
	
	@RequestMapping("consumir")
	public @ResponseBody Iterable<Cidade> consumir(){
		return service.consumirCidades();
	}
}

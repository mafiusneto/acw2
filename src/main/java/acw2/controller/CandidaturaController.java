package acw2.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import acw2.domain.Candidatura;
import acw2.domain.Politico;
import acw2.domain.Usuario;
import acw2.domain.dto.CandidaturaSearch;
import acw2.domain.dto.Login;
import acw2.service.CandidaturaService;

@RestController
@RequestMapping("candidatura")
public class CandidaturaController {

	@Autowired
	private CandidaturaService service; 
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Candidatura> lista() {
		Iterable<Candidatura> candidaturas = service.list();
		return candidaturas;
	}
	
	@RequestMapping(value="/src", method = RequestMethod.GET)
	public @ResponseBody List<Candidatura> search1(
			@RequestParam(name="politico", required=false, defaultValue="0") String politico, 
			@RequestParam(name="cidade", required=false, defaultValue="0") String cidade){
		
		System.out.println("!!!   "+politico + " - "+ cidade);	
		List<Candidatura> list = null;
				
		try {			
		
			if (!politico.equals("0")  & !cidade.equals("0")){
				list = service.findByPolitico_Cidade(Long.parseLong(politico), Long.parseLong(cidade));
				
			}else if (!politico.equals("0")){
				list = service.findByIdPolitico(Long.parseLong(politico));
				
			}else if (!cidade.equals("0")){
				list = service.findByIdCidade(Long.parseLong(cidade));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;		
	}
	
	@PostMapping()
	public Long cadastrarCandidatura(@RequestBody @Valid Candidatura candidatura) {
		return service.save(candidatura);
	}
	
	@PutMapping()
	public Long alterarCandidatura(@RequestBody @Valid Candidatura candidatura) { //
		if (candidatura.getId() == 0){
			return 0L;
		}else{
			Candidatura p = service.getById(candidatura.getId());
			if (p == null){
				return 0L;
			}
		}
		return service.save(candidatura);
	}
	
	@DeleteMapping(value="/{id}")
	public Long deletaCandidatura(@PathVariable Long id) {
		try {
			service.delete(id);
			return id;			
		} catch (Exception e) {
			return 0L;
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody Candidatura getById(@PathVariable long id) {
		Candidatura candidatura = service.getById(id);
		return candidatura;
	}
}

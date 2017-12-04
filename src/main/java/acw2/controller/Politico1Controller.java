package acw2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import acw2.domain.Politico;
import acw2.service.PoliticoService;

@Controller
@RequestMapping("politico1")
public class Politico1Controller {

	@Autowired
	private PoliticoService service; 
		
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Politico> list() {		
		List<Politico> politicos = new ArrayList<Politico>(service.list());		
		return politicos;
	}
	
	@RequestMapping("/{id}")
	public @ResponseBody Politico getById(@PathVariable Long id){
		Politico politico = service.getById(id); 		
		return politico;
	}
	
	@RequestMapping(path="/save",method=RequestMethod.POST)
	public @ResponseBody Long save(@RequestBody Politico politico){
		return service.save(politico)	;
	}
		
	@RequestMapping(path="/delete/{id}",method=RequestMethod.GET)
	public @ResponseBody Long delete(@PathVariable Long id){
		try {
			service.delete(id);
			
		} catch (Exception e) {
			return 0l;
		}
		return id;
	}
	
	/*
	 @RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<PoliticoDto> list() {
		List<PoliticoDto> cursosDto = new ArrayList<PoliticoDto>();
		for (Politico curso :  new ArrayList<Politico>(service.list())) {
			PoliticoDto cursoDto = new PoliticoDto();
			BeanUtils.copyProperties(curso, cursoDto);
			cursoDto.setPeriodos(null);
			
			List<PeriodoDto> periodosDto = new ArrayList<PeriodoDto>();
			for (Periodo periodo : curso.getPeriodos()) {
				PeriodoDto periodoDto = new PeriodoDto();
				BeanUtils.copyProperties(periodo, periodoDto);
				
				periodoDto.setDisciplinas(null);
				
				if (periodo.getDisciplinas() != null){
					List<DisciplinaDto> listaDisciplinaDto = new ArrayList<DisciplinaDto>();
					
					for (Disciplina disciplina : periodo.getDisciplinas()){
						DisciplinaDto disciplinaDto = new DisciplinaDto();
						BeanUtils.copyProperties(disciplina, disciplinaDto);
						
						if (disciplina.getExpertises() != null){
							List<ExpertiseDto> listaExpertiseDto = new ArrayList<ExpertiseDto>();
							
							for(Expertise expertise : disciplina.getExpertises()){
								ExpertiseDto expertiseDto = new ExpertiseDto();
								BeanUtils.copyProperties(expertise, expertiseDto);
								expertiseDto.setDisciplinas(null);
								expertiseDto.setProfessores(null);
								listaExpertiseDto.add(expertiseDto);
							}
							disciplinaDto.setExpertises(listaExpertiseDto);
						}
						
						listaDisciplinaDto.add(disciplinaDto);
						
					}
					
					periodoDto.setDisciplinas(listaDisciplinaDto);
				}
				
				periodosDto.add(periodoDto);
			}
			
			cursoDto.setPeriodos(periodosDto);
			
			cursosDto.add(cursoDto);
			
		}
		
		return cursosDto;
	}
	
	@RequestMapping("/{id}")
	public @ResponseBody PoliticoDto getById(@PathVariable Long id){
		Politico curso = service.getById(id); 
		PoliticoDto cursoDto = new PoliticoDto();
		BeanUtils.copyProperties(curso, cursoDto);
		cursoDto.setPeriodos(null);
		
		List<PeriodoDto> periodosDto = new ArrayList<PeriodoDto>();
		for (Periodo periodo : curso.getPeriodos()) {
			PeriodoDto periodoDto = new PeriodoDto();
			BeanUtils.copyProperties(periodo, periodoDto);
			
			periodoDto.setDisciplinas(null);
			
			if (periodo.getDisciplinas() != null){
				List<DisciplinaDto> listaDisciplinaDto = new ArrayList<DisciplinaDto>();
				
				for (Disciplina disciplina : periodo.getDisciplinas()){
					DisciplinaDto disciplinaDto = new DisciplinaDto();
					BeanUtils.copyProperties(disciplina, disciplinaDto);
					
					if (disciplina.getExpertises() != null){
						List<ExpertiseDto> listaExpertiseDto = new ArrayList<ExpertiseDto>();
						
						for(Expertise expertise : disciplina.getExpertises()){
							ExpertiseDto expertiseDto = new ExpertiseDto();
							BeanUtils.copyProperties(expertise, expertiseDto);
							expertiseDto.setDisciplinas(null);
							expertiseDto.setProfessores(null);
							listaExpertiseDto.add(expertiseDto);
						}
						disciplinaDto.setExpertises(listaExpertiseDto);
					}
					
					listaDisciplinaDto.add(disciplinaDto);
					
				}
				
				periodoDto.setDisciplinas(listaDisciplinaDto);
			}
			
			periodosDto.add(periodoDto);
		}
		
		cursoDto.setPeriodos(periodosDto);
		
		return cursoDto;
	}
	 
	*/
	
}

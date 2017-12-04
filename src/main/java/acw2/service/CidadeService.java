package acw2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acw2.domain.Cidade;
import acw2.repository.CidadeRepository;

@Service
public class CidadeService extends AbstractService<Cidade>{
	
	@Autowired
	private CidadeRepository repository;

	public List<Cidade> list() {
		return  (List<Cidade>) repository.findAll();
	}
	
	public Cidade getById(Long id){
		return (Cidade) repository.findOne(id);
	}
	
	public Long save(Cidade curso){
		Cidade obj = null;
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
	
	public List<Cidade> finds(List<Long> ids) {
		return  (List<Cidade>) repository.findAll(ids);
	}
	
	/*
	public List<CursoDto> finds2(List<Long> ids) {
		List<CursoDto> listaCursoDto = new ArrayList<CursoDto>();
		
		for (Curso curso : (List<Curso>) repository.findAll(ids)){
			CursoDto cursoDto = new CursoDto();
			BeanUtils.copyProperties(curso, cursoDto);
			
			cursoDto.setPeriodos(null);
			
			//cursoDto.setProfessores(null);
			//cursoDto.setDisciplinas(null);
			listaCursoDto.add(cursoDto);
			
		}
		
		return listaCursoDto;		
		//return  (List<Curso>) repository.findAll(ids);
	}*/
	
}

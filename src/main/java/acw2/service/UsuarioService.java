package acw2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.EventException;

import acw2.domain.Usuario;
import acw2.repository.UsuarioRepository;

@Service
public class UsuarioService extends AbstractService<Usuario>{
	
	@Autowired
	private UsuarioRepository repository;
	
	/*
	public Usuario login(String email, String senha){
		System.out.println("Busca por:  Email:"+email+"| Senha:"+senha);
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) repository.findAll();
		for (Usuario usuario : usuarios) {
			System.out.println("enc:  User= Email:"+usuario.getEmail()+"| Senha:"+usuario.getSenha());
			if (usuario.getEmail().equals(email) & usuario.getSenha().equals(senha) ){// & usuario.getSenha() == senha

				System.out.println("### achou");
				return usuario;
			}
		}
		System.out.println("### retornou null");
		return null;//new Usuario( repository.login(email, senha);
	}*/
	public Usuario login(String email, String senha){
		Usuario usuario = repository.login(email, senha);
		return usuario;
	}

	public List<Usuario> list() {
		return  (List<Usuario>) repository.findAll();
	}
	
	public Usuario getById(Long id){
		return (Usuario) repository.findOne(id);
	}
	
	public Long save(Usuario curso){
		Usuario obj = null;
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
	
	public List<Usuario> finds(List<Long> ids) {
		return  (List<Usuario>) repository.findAll(ids);
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

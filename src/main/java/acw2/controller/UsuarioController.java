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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import acw2.domain.Usuario;
import acw2.domain.dto.Login;
import acw2.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service; 
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Usuario> lista() {
		Iterable<Usuario> usuarios = service.list();
		return usuarios;
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public Usuario login(@RequestBody Login login){
		//System.out.println("Email:"+login.getEmail()+"| Senha:"+login.getSenha());
		Usuario usuario = service.login(login.getEmail(), login.getSenha());
		return usuario;		
	}
	
	
	@PostMapping()
	public Long cadastrarUsuario(@RequestBody @Valid Usuario usuario) {
		return service.save(usuario);
	}
	
	@PutMapping()
	public Long alterarUsuario(@RequestBody @Valid Usuario usuario) {
		if (usuario.getId() == 0){
			return 0L;
		}else{
			Usuario p = service.getById(usuario.getId());
			if (p == null){
				return 0L;
			}
		}
		return service.save(usuario);
	}
	
	@DeleteMapping(value="/{id}")
	public Long deletaUsuario(@PathVariable Long id) {
		try {
			service.delete(id);
			return id;			
		} catch (Exception e) {
			return 0L;
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody Usuario getById(@PathVariable long id) {
		Usuario usuario = service.getById(id);
		return usuario;
	}
}

package acw2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import acw2.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	@Query("select u from usuario u where u.email = ?1 and u.senha= ?2")
	Usuario login(String email,String senha);
	
}

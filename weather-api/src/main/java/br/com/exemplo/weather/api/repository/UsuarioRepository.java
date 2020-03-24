package br.com.exemplo.weather.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exemplo.weather.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Optional<Usuario> findByEmail(String email);
	
}

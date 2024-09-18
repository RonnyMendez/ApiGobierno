package com.gobierno.backend.repositories;


import com.gobierno.backend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Puedes agregar métodos personalizados si lo necesitas, por ejemplo:
    // Optional<Usuario> findByCorreoElectronico(String correoElectronico);
}
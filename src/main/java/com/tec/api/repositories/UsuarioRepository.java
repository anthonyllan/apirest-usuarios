package com.tec.api.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tec.api.models.MUsuario;

@Repository
public interface  UsuarioRepository extends CrudRepository<MUsuario, Long> {
    public abstract ArrayList<MUsuario> findByPrioridad(Integer prioridad);
}

package com.tec.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tec.api.models.MUsuario;
import com.tec.api.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public ArrayList<MUsuario> obtenerUsuarios() {
        return (ArrayList<MUsuario>) usuarioRepository.findAll();
    }

    // Guardar o actualizar un usuario
    public void guardarUsuario(MUsuario usuario) {
        usuarioRepository.save(usuario);
    }

    // Obtener un usuario por su ID
    public Optional<MUsuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public ArrayList<MUsuario> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    // Eliminar un usuario por su ID
    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

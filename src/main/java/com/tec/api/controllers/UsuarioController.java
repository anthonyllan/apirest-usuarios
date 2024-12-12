package com.tec.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tec.api.models.MUsuario;
import com.tec.api.services.UsuarioService;
//ip del cliente
@CrossOrigin(origins = "http://192.168.213.112:3000")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    // Listar usuarios
    @GetMapping("/list")
    public List<MUsuario> listarUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    // Guardar usuario
    @PostMapping("/guardar")
    public MUsuario guardarUsuario(@RequestBody MUsuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return usuario;
    }

    // Actualizar usuario
    @PutMapping("/actualizar")
    public MUsuario actualizarUsuario(@RequestBody MUsuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return usuario;
    }

    @GetMapping(path = "/{id}")
    public Optional<MUsuario> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerUsuarioPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<MUsuario>obtenerPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
        
    }

    /*public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó correctamente el usuario con id: " + id;
        } else {
            return "No se pudo eliminar el usuario con id: " + id;   
        }
    }*/
    
    // Eliminar usuario
    @DeleteMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó correctamente el usuario con id: " + id;
        } else {
            return "No se pudo eliminar el usuario con id: " + id;
        }
    }
}
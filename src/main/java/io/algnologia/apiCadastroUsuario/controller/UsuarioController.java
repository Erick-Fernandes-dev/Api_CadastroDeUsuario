package io.algnologia.apiCadastroUsuario.controller;

import io.algnologia.apiCadastroUsuario.model.Usuario;
import io.algnologia.apiCadastroUsuario.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getAll() {

        return usuarioService.pegarTodos();

    }

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody Usuario usuario) {
        this.usuarioService.adicionar(usuario);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        this.usuarioService.deletar(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        this.usuarioService.atualizar(id, usuario);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public List<Usuario> pegarUsuarioId(@PathVariable Long id) {
        return this.usuarioService.pegarUsuarioPorId(id);
    }

}

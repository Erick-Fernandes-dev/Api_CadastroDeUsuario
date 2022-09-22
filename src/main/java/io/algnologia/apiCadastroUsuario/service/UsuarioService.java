package io.algnologia.apiCadastroUsuario.service;


import io.algnologia.apiCadastroUsuario.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioService {

    private List<Usuario> lista = new ArrayList<>();

    //cadastro
    public void adicionar(Usuario usuario) {
        this.lista.add(usuario);
    }

    //pegar todos
    public List<Usuario> pegarTodos() {
        return  this.lista;
    }


    // pegar por id
    public List<Usuario> pegarUsuarioPorId(Long id) {

        List<Usuario> selecionado = new ArrayList<>();


        for (Usuario user: this.lista) {

            if (user.getId() == id) {
                selecionado.add(user);
            }

        }
        return selecionado;
    }

    // deletar
    public void deletar(Long id) {
        int converte = Integer.parseInt(String.valueOf(id));
        Usuario usuario = this.lista.get(Math.toIntExact(id));

        if (usuario.getId() == id) {
            lista.remove(usuario);
        }


    }

    //atualizar

    public void atualizar(Long id, Usuario usuario) {

        int converte = Integer.parseInt(String.valueOf(id));
        Usuario user = this.lista.get(Math.toIntExact(id));

        if (user.getId().equals(id)) {
            user.setNome(usuario.getNome());
            user.setEmail(usuario.getEmail());
            user.setEndereco(usuario.getEndereco());
            user.setTelefone(usuario.getTelefone());
        }

    }

}

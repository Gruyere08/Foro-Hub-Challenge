package com.ChallengeAlura.ForoHub.domain.topico;


import com.ChallengeAlura.ForoHub.domain.topico.validaciones.ValidadorDeTopicos;
import com.ChallengeAlura.ForoHub.domain.usuario.Usuario;
import com.ChallengeAlura.ForoHub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroDeTopicos {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private List<ValidadorDeTopicos> validadores;

    public DatosDetalleTopico registrarTopico(DatosRegistroTopico datos){

        validadores.forEach(v -> v.validarRegistro(datos));

        Usuario autor = usuarioRepository.getReferenceById(datos.autorId());

        Topico topico = new Topico(datos, autor);
        topicoRepository.save(topico);
        return new DatosDetalleTopico(datos.titulo(), datos.mensaje(), autor.getLogin());
    }

}

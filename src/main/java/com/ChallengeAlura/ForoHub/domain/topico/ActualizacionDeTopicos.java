package com.ChallengeAlura.ForoHub.domain.topico;

import com.ChallengeAlura.ForoHub.domain.topico.validaciones.ValidadorDeTopicos;
import com.ChallengeAlura.ForoHub.domain.usuario.Usuario;
import com.ChallengeAlura.ForoHub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualizacionDeTopicos {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private List<ValidadorDeTopicos> validadores;

    public DatosRespuestaTopico actualizarTopico(DatosActualizacionTopico datos, Long topicoID){

        validadores.forEach(v -> v.validarActualizacion(datos));
        Topico topico = topicoRepository.getReferenceById(topicoID);
        if (datos.autorId() != null){
            Usuario autor = usuarioRepository.getReferenceById(datos.autorId());
            topico.setAutor(autor);
        }
        topico.actualizarDatos(datos);

        topicoRepository.save(topico);

        return new DatosRespuestaTopico(topico);
    }

}

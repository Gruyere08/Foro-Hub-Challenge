package com.ChallengeAlura.ForoHub.domain.topico.validaciones;


import com.ChallengeAlura.ForoHub.domain.ValidacionException;
import com.ChallengeAlura.ForoHub.domain.topico.DatosRegistroTopico;
import com.ChallengeAlura.ForoHub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoRepetido implements ValidadorDeTopicos {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DatosRegistroTopico datos) {
        if(topicoRepository.existsByTituloAndMensaje(datos.titulo(),datos.mensaje())){
            throw new ValidacionException("El topico que se desea registrar es igual a uno existente");
        }
    }
}

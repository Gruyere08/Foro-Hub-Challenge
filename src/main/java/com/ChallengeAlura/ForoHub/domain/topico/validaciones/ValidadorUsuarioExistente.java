package com.ChallengeAlura.ForoHub.domain.topico.validaciones;


import com.ChallengeAlura.ForoHub.domain.ValidacionException;
import com.ChallengeAlura.ForoHub.domain.topico.DatosActualizacionTopico;
import com.ChallengeAlura.ForoHub.domain.topico.DatosRegistroTopico;
import com.ChallengeAlura.ForoHub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorUsuarioExistente implements ValidadorDeTopicos {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validarRegistro(DatosRegistroTopico datos) {
        if (!usuarioRepository.existsById(datos.autorId())){
            throw new ValidacionException("El usuario que se desea acceder no existe");
        }
    }

    @Override
    public void validarActualizacion(DatosActualizacionTopico datos) {
        if (datos.autorId() == null){
            return;
        }
        if (!usuarioRepository.existsById(datos.autorId())){
            throw new ValidacionException("El usuario que se desea acceder no existe");
        }
    }
}

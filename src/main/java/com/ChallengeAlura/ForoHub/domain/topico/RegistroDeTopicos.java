package com.ChallengeAlura.ForoHub.domain.topico;


import com.ChallengeAlura.ForoHub.domain.topico.validaciones.ValidadorDeTopicos;
import org.springframework.stereotype.Service;

@Service
public class RegistroDeTopicos {



    public DatosDetalleTopico registrarTopico(DatosRegistroTopico datos){

        return new DatosDetalleTopico("","","");
    }

}

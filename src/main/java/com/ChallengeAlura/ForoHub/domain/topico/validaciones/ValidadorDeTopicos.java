package com.ChallengeAlura.ForoHub.domain.topico.validaciones;

import com.ChallengeAlura.ForoHub.domain.topico.DatosActualizacionTopico;
import com.ChallengeAlura.ForoHub.domain.topico.DatosRegistroTopico;

public interface ValidadorDeTopicos {
    void validarRegistro(DatosRegistroTopico datos);

    void validarActualizacion(DatosActualizacionTopico datos);
}

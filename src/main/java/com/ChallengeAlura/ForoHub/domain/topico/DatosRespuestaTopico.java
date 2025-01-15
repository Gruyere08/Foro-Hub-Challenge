package com.ChallengeAlura.ForoHub.domain.topico;

import com.ChallengeAlura.ForoHub.domain.status.Status;

import java.util.Date;

public record DatosRespuestaTopico(
        String titulo,
        String mensaje,
        Date fechaCreacion,
        Status status,
        Long autorId,
        String autorNombre
) {
    public DatosRespuestaTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getAutor().getNombre()
        );
    }
}

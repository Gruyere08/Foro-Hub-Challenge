package com.ChallengeAlura.ForoHub.domain.topico;

import com.ChallengeAlura.ForoHub.domain.status.Status;

import java.util.Date;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        Date fechaCreacion,
        Status status,
        Long autorId
) {
    public DatosListadoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getId()
        );
    }
}


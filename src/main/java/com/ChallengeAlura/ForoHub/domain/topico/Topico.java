package com.ChallengeAlura.ForoHub.domain.topico;

import com.ChallengeAlura.ForoHub.domain.respuesta.Respuesta;
import com.ChallengeAlura.ForoHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensaje;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @NotBlank
    private String status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;


}


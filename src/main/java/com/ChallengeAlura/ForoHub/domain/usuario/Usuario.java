package com.ChallengeAlura.ForoHub.domain.usuario;

import com.ChallengeAlura.ForoHub.domain.respuesta.Respuesta;
import com.ChallengeAlura.ForoHub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correoElectronico;

    private String contrasena;

    @OneToMany(mappedBy = "autor")
    private List<Topico> topicos = new ArrayList<>();

    @OneToMany(mappedBy = "autor")
    private List<Respuesta> respuestas = new ArrayList<>();

    public void addTopico(Topico topico){
        this.topicos.add(topico);
    }

    public void addRespuesta(Respuesta respuesta){
        this.respuestas.add(respuesta);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }
}


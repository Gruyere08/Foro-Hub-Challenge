package com.ChallengeAlura.ForoHub.domain.usuario;

import com.ChallengeAlura.ForoHub.domain.respuesta.Respuesta;
import com.ChallengeAlura.ForoHub.domain.topico.Topico;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity(name = "Usuario")
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String correoElectronico;

    private String clave;

    @OneToMany(mappedBy = "autor")
    private List<Topico> topicos = new ArrayList<>();

    @OneToMany(mappedBy = "autor")
    private List<Respuesta> respuestas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String correoElectronico, String contrasena, List<Topico> topicos, List<Respuesta> respuestas) {
        this.id = id;
        this.login = nombre;
        this.correoElectronico = correoElectronico;
        this.clave = contrasena;
        this.topicos = topicos;
        this.respuestas = respuestas;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void addTopico(Topico topico) {
        this.topicos.add(topico);
    }

    public void addRespuesta(Respuesta respuesta) {
        this.respuestas.add(respuesta);
    }

    // SPRING SECURITY


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




}



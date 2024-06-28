package pe.edu.upao.InversionesJI.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name= "Agente")
public class Agente implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agente_seq")
    @SequenceGenerator(name = "agente_seq", sequenceName = "agente_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "contrasena")
    private String password;

    @Column(name = "correo")
    private String username;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "dni")
    private String dni;

    @Column(name = "nombre_inmobiliaria")
    private String nombreInmobiliaria;

    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
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

    @ManyToOne
    @JoinColumn(name = "id_inmobiliaria")
    @JsonBackReference
    private Inmobiliaria inmobiliaria;
}

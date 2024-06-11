package pe.edu.upao.InversionesJI.Entity;

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
    private String nombre;
    private String apellido;
    private String password;
    private String username;
    private String telefono;
    private String dni;
    private String role;
    private String nombreInmobiliaria;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Inmobiliaria")
    private Inmobiliaria inmobiliaria;
}

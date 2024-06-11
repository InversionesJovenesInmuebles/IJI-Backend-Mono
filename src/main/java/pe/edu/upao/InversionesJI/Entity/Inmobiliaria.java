package pe.edu.upao.InversionesJI.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name= "Inmobiliaria")
public class Inmobiliaria implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inmobiliaria_seq")
    @SequenceGenerator(name = "inmobiliaria_seq", sequenceName = "inmobiliaria_sequence", allocationSize = 1)
    private Long idInmobiliaria;
    private String nombreInmobiliaria;
    private String direccion;
    private String username;
    private String password;
    private String ruc;
    private String telefonoContacto;
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

    @OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agente> agentes = new ArrayList<>();

    // Add agent to list
    public void addAgente(Agente agente) {
        agentes.add(agente);
        agente.setInmobiliaria(this);
    }

    // Remove agent from list
    public void removeAgente(Agente agente) {
        agentes.remove(agente);
        agente.setInmobiliaria(null);
    }
}

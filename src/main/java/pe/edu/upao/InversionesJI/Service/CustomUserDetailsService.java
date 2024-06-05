package pe.edu.upao.InversionesJI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upao.InversionesJI.Entity.Cliente;
import pe.edu.upao.InversionesJI.Repository.ClienteRepository;

import java.util.Optional;

@Service
@Primary
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar en la entidad Cliente
        Optional<Cliente> cliente = clienteRepository.findByUsername(username);
        if (cliente.isPresent()) {
            return cliente.get();
        }

        // Si no se encuentra el usuario en ninguna entidad, lanzar una excepción
        throw new UsernameNotFoundException("Usuario no encontrado");
    }
}


package pe.edu.upao.InversionesJI.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upao.InversionesJI.Entity.Agente;
import pe.edu.upao.InversionesJI.Entity.Inmobiliaria;
import pe.edu.upao.InversionesJI.Jwt.JwtService;
import pe.edu.upao.InversionesJI.Repository.AgenteRepository;
import pe.edu.upao.InversionesJI.Repository.InmobiliariaRepository;
import pe.edu.upao.InversionesJI.Request.RegisterAgenteRequest;
import pe.edu.upao.InversionesJI.Request.RegisterInmobiliariaRequest;
import pe.edu.upao.InversionesJI.Response.AuthResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InmobiliariaService {

    private final InmobiliariaRepository inmobiliariaRepository;
    private final AgenteRepository agenteRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    //Agregar Inmobiliaria
    public AuthResponse agregarInmobiliaria(RegisterInmobiliariaRequest request) {
        System.out.println("Solicitud para agregar inmobiliaria recibida: " + request);
        Inmobiliaria inmobiliaria = new Inmobiliaria();
        inmobiliaria.setNombreInmobiliaria(request.getNombreInmobiliaria());
        inmobiliaria.setRole("Inmobiliaria");
        inmobiliaria.setUsername(request.getCorreo());
        inmobiliaria.setPassword(passwordEncoder.encode(request.getContrasena()));
        inmobiliaria.setRuc(request.getRuc());
        inmobiliaria.setTelefonoContacto(request.getTelefonoContacto());
        inmobiliaria.setDireccion(request.getDireccion());
        inmobiliariaRepository.save(inmobiliaria);

        return AuthResponse.builder()
                .token(jwtService.getToken(inmobiliaria))
                .build();
    }

    //Agregar a un agente
    public AuthResponse agregarAgente(RegisterAgenteRequest request) {
        System.out.println("Solicitud para agregar agentes recibida: " + request);
        Agente agente = new Agente();
        agente.setNombre(request.getNombre());
        agente.setApellido(request.getApellido());
        agente.setRole("Agente");
        agente.setUsername(request.getCorreo());
        agente.setPassword(passwordEncoder.encode(request.getContrasena()));
        agente.setDni(request.getDni());
        agente.setTelefono(request.getTelefono());
        agente.setNombreInmobiliaria(request.getNombreInmobiliaria());
        agenteRepository.save(agente);

        return AuthResponse.builder()
                .token(jwtService.getToken(agente))
                .build();
    }

    //Listar a todos los agentes
    public List<Agente> listarAgentes() {
        return agenteRepository.findAll();
    }
}
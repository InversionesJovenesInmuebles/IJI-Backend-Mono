package pe.edu.upao.InversionesJI.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upao.InversionesJI.Entity.Inmobiliaria;
import pe.edu.upao.InversionesJI.Jwt.JwtService;
import pe.edu.upao.InversionesJI.Repository.InmobiliariaRepository;
import pe.edu.upao.InversionesJI.Request.RegisterInmobiliariaRequest;
import pe.edu.upao.InversionesJI.Response.AuthResponse;

@Service
@RequiredArgsConstructor
public class InmobiliariaService {

    private final InmobiliariaRepository inmobiliariaRepository;
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
}
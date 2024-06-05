package pe.edu.upao.InversionesJI.InmobiliariaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import pe.edu.upao.InversionesJI.Jwt.JwtService;
import pe.edu.upao.InversionesJI.Repository.InmobiliariaRepository;
import pe.edu.upao.InversionesJI.Request.RegisterInmobiliariaRequest;
import pe.edu.upao.InversionesJI.Response.AuthResponse;
import pe.edu.upao.InversionesJI.Service.InmobiliariaService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InmobiliariaServiceTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private InmobiliariaRepository InmobiliariaRepository;

    @InjectMocks
    private InmobiliariaService inmobiliariaService;

    @Test
    public void testAgregarInmobiliaria() {
        RegisterInmobiliariaRequest request = new RegisterInmobiliariaRequest();
        request.setNombreInmobiliaria("Palomita Enterprise");
        request.setCorreo("palomita123@gmail.com");
        request.setContrasena("123456");
        request.setDireccion("Las palomas 212");
        request.setTelefonoContacto("928301637");
        request.setRuc("298417270");

        when(passwordEncoder.encode(anyString())).thenReturn("contraseñaEncriptada");
        when(jwtService.getToken(any())).thenReturn("token");

        AuthResponse response = inmobiliariaService.agregarInmobiliaria(request);

        assertNotNull(response);
        assertEquals("token", response.getToken());
    }
}


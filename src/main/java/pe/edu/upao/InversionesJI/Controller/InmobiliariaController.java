package pe.edu.upao.InversionesJI.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.InversionesJI.Request.RegisterInmobiliariaRequest;
import pe.edu.upao.InversionesJI.Service.InmobiliariaService;

@RestController
@RequestMapping("/inmobiliaria")
@RequiredArgsConstructor
public class InmobiliariaController {

    private final InmobiliariaService inmobiliariaService;

    @PostMapping(value = "/registrarInmobiliaria")
    public ResponseEntity<?> agregarInmobiliaria(@RequestBody RegisterInmobiliariaRequest request) {
        // Log para verificar si la solicitud llega al controlador
        System.out.println("Solicitud para registrar inmobiliaria recibida.");

        // Código para registrar la inmobiliaria
        return ResponseEntity.ok(inmobiliariaService.agregarInmobiliaria(request));
    }
}

package pe.edu.upao.InversionesJI.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.InversionesJI.Entity.Agente;
import pe.edu.upao.InversionesJI.Entity.Inmobiliaria;
import pe.edu.upao.InversionesJI.Request.RegisterAgenteRequest;
import pe.edu.upao.InversionesJI.Request.RegisterInmobiliariaRequest;
import pe.edu.upao.InversionesJI.Service.InmobiliariaService;

import java.util.List;

@RestController
@RequestMapping("/inmobiliaria")
@RequiredArgsConstructor
public class InmobiliariaController {

    private final InmobiliariaService inmobiliariaService;

    //Agregar Inmobiliaria
    @PostMapping(value = "/registrarInmobiliaria")
    public ResponseEntity<?> agregarInmobiliaria(@RequestBody RegisterInmobiliariaRequest request) {
        // Log para verificar si la solicitud llega al controlador
        System.out.println("Solicitud para registrar inmobiliaria recibida.");

        // Código para registrar la inmobiliaria
        return ResponseEntity.ok(inmobiliariaService.agregarInmobiliaria(request));
    }

    @GetMapping("/listarInmobiliariaToken")
    public ResponseEntity<Inmobiliaria> obtenerDatosInmobiliaria(@RequestHeader("Authorization") String token) {
        String tokenSinBearer = token.replace("Bearer ", "");
        Inmobiliaria inmobiliaria = inmobiliariaService.obtenerInmobiliariaPorToken(tokenSinBearer);
        return ResponseEntity.ok(inmobiliaria);
    }

    //AGENTE

    //Listar agentes por inmobiliaria
    @GetMapping("/listarAgentes/{nombreInmobiliaria}")
    public ResponseEntity<List<Agente>> listarAgentesInmobiliaria(@PathVariable String nombreInmobiliaria) {
        List<Agente> agentes = inmobiliariaService.listarAgentesInmobiliaria(nombreInmobiliaria);
        return ResponseEntity.ok(agentes);
    }

    //Listar a todos los agentes
    @GetMapping("/listarAgentes")
    public ResponseEntity<List<Agente>> listarAgentes() {
        List<Agente> agentes = inmobiliariaService.listarAgentes();
        return ResponseEntity.ok(agentes);
    }

    // Obtener agente por ID
    @GetMapping("/obtenerAgente/{id}")
    public ResponseEntity<Agente> obtenerAgentePorId(@PathVariable Long id) {
        Agente agente = inmobiliariaService.obtenerAgentePorId(id);
        return ResponseEntity.ok(agente);
    }

    //Agregar agente
    @PostMapping(value = "/registrarAgente")
    public ResponseEntity<?> agregarAgente(@RequestBody RegisterAgenteRequest request) {
        return ResponseEntity.ok(inmobiliariaService.agregarAgente(request));
    }

    //Modificar agente
    @PutMapping("/modificarAgente/{id}")
    public ResponseEntity<Agente> modificarAgente(@PathVariable Long id, @RequestBody RegisterAgenteRequest request) {
        Agente agenteModificado = inmobiliariaService.modificarAgente(id, request);
        return ResponseEntity.ok(agenteModificado);
    }

    //Eliminar agente
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarAgente(@PathVariable("id") Long id) {
        return ResponseEntity.ok(inmobiliariaService.eliminarAgente(id));
    }
}

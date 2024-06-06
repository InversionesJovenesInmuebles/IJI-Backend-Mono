package pe.edu.upao.InversionesJI.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.InversionesJI.Dto.CasaDto;
import pe.edu.upao.InversionesJI.Dto.DepartamentoDto;
import pe.edu.upao.InversionesJI.Service.AgenteService;

@RestController
@RequestMapping("/agente")
@AllArgsConstructor
public class AgenteController {

    private final AgenteService agenteService;

    //CASA

    //Agregar una casa
    @PostMapping("/agregarCasa")
    public ResponseEntity<String> agregarCasa(@RequestBody CasaDto casaDto) {
        try {
            agenteService.agregarCasa(casaDto);
            return ResponseEntity.ok("Casa agregada correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //DEPARTAMENTO

    //Agregar un departamento
    @PostMapping("/agregarDepartamento")
    public ResponseEntity<String> agregarDepartamento(@RequestBody DepartamentoDto departamentoDto) {
        try {
            agenteService.agregarDepartamento(departamentoDto);
            return ResponseEntity.ok("Departamento agregado correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

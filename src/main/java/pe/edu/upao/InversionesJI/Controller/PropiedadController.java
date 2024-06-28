package pe.edu.upao.InversionesJI.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upao.InversionesJI.Dto.PropiedadDto;
import pe.edu.upao.InversionesJI.Feign.PropiedadFeignClient;

import java.util.List;

@RestController
@RequestMapping("/propiedad")
@RequiredArgsConstructor
public class PropiedadController {

    private final PropiedadFeignClient propiedadFeignClient;

    //Listar propiedades
    @GetMapping("/listarPropiedades")
    public ResponseEntity<List<PropiedadDto>> listarPropiedades() {
        List<PropiedadDto> propiedades = propiedadFeignClient.listarPropiedades();
        return ResponseEntity.ok(propiedades);
    }

    //Listar una propiedad por su ID
    @GetMapping("/listarPropiedad/{id}")
    public ResponseEntity<PropiedadDto> obtenerPropiedadPorId(@PathVariable Long id) {
        PropiedadDto propiedad = propiedadFeignClient.obtenerPropiedadPorId(id);
        return ResponseEntity.ok(propiedad);
    }
}

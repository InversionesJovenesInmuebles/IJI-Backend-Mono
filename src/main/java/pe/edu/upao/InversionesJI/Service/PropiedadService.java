package pe.edu.upao.InversionesJI.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upao.InversionesJI.Entity.Propiedad;
import pe.edu.upao.InversionesJI.Repository.PropiedadRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PropiedadService {

    private final PropiedadRepository propiedadRepository;

    //Listar las propiedades almacenadas del sistema
    public List<Propiedad> listarPropiedades() {
        return propiedadRepository.findAll();
    }

    //Listar una propiedad por su ID
    public Propiedad obtenerPropiedadPorId(Long id) {
        return propiedadRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró la propiedad con el ID " + id));
    }
}

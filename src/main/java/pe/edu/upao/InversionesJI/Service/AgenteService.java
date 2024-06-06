package pe.edu.upao.InversionesJI.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upao.InversionesJI.Dto.CasaDto;
import pe.edu.upao.InversionesJI.Dto.DepartamentoDto;
import pe.edu.upao.InversionesJI.Dto.FotoDto;
import pe.edu.upao.InversionesJI.Dto.PropiedadDto;
import pe.edu.upao.InversionesJI.Entity.Casa;
import pe.edu.upao.InversionesJI.Entity.Departamento;
import pe.edu.upao.InversionesJI.Entity.Foto;
import pe.edu.upao.InversionesJI.Entity.Propiedad;
import pe.edu.upao.InversionesJI.Repository.PropiedadRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AgenteService {

    private final PropiedadRepository propiedadRepository;

    //Convertir la propeidad en base al tipo de propiedad
    private <T extends Propiedad> T convertirPropiedad(PropiedadDto propiedadDto, T propiedad) {
        propiedad.setLatitud(propiedadDto.getLatitud());
        propiedad.setLongitud(propiedadDto.getLongitud());
        propiedad.setPais(propiedadDto.getPais());
        propiedad.setRegion(propiedadDto.getRegion());
        propiedad.setProvincia(propiedadDto.getProvincia());
        propiedad.setDistrito(propiedadDto.getDistrito());
        propiedad.setDireccion(propiedadDto.getDireccion());
        propiedad.setDescripcion(propiedadDto.getDescripcion());
        propiedad.setOtrasComodidades(propiedadDto.getOtrasComodidades());
        propiedad.setTipoPropiedad(propiedadDto.getTipoPropiedad());
        propiedad.setAreaTerreno(propiedadDto.getAreaTerreno());
        propiedad.setCostoTotal(propiedadDto.getCostoTotal());
        propiedad.setCostoInicial(propiedadDto.getCostoInicial());
        propiedad.setCochera(propiedadDto.isCochera());
        propiedad.setCantBanos(propiedadDto.getCantBanos());
        propiedad.setCantDormitorios(propiedadDto.getCantDormitorios());
        propiedad.setCantCochera(propiedadDto.getCantCochera());

        // Asignar fotos
        List<Foto> fotos = convertirFotos(propiedadDto.getFotos(), propiedad);
        propiedad.setFotos(fotos);

        return propiedad;
    }

    //Lista de fotos para las propiedades
    private List<Foto> convertirFotos(List<FotoDto> fotosDto, Propiedad propiedad) {
        return fotosDto.stream()
                .map(fotoDto -> {
                    Foto foto = new Foto();
                    foto.setNombreFoto(fotoDto.getNombreFoto());
                    foto.setPropiedad(propiedad);
                    return foto;
                })
                .collect(Collectors.toList());
    }

    //CASA

    //Agregar Casa
    public void agregarCasa(CasaDto casaDto) {
        Casa casa = convertirPropiedad(casaDto, new Casa());

        //Atributos de la propiedad casa
        casa.setSotano(casaDto.isSotano());
        casa.setAreaJardin(casaDto.getAreaJardin());
        casa.setAtico(casaDto.isAtico());
        casa.setJardin(casaDto.isJardin());
        casa.setCantPisos(casaDto.getCantPisos());
        propiedadRepository.save(casa);
    }

    //DEPARTAMENTO

    //Agregar Departamento
    public void agregarDepartamento(DepartamentoDto departamentoDto) {
        Departamento departamento = convertirPropiedad(departamentoDto, new Departamento());

        //Atributos de la propiedad departamento
        departamento.setPisos(departamentoDto.getPisos());
        departamento.setInterior(departamentoDto.getInterior());
        departamento.setAscensor(departamentoDto.isAscensor());
        departamento.setAreasComunes(departamentoDto.isAreasComunes());
        departamento.setAreasComunesEspecificas(departamentoDto.getAreasComunesEspecificas());
        propiedadRepository.save(departamento);
    }
}

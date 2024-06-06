package pe.edu.upao.InversionesJI.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PropiedadDto {

    //Dirección de las propiedades

    @NotNull
    @NotBlank(message = "La latitud no debe estar en blanco")
    private String latitud;

    @NotNull
    @NotBlank(message = "La longitud no debe estar en blanco")
    private String longitud;

    @NotNull
    @NotBlank(message = "El país no debe estar en blanco")
    private String pais;

    @NotNull
    @NotBlank(message = "La región no debe estar en blanco")
    private String region;

    @NotNull
    @NotBlank(message = "La provincia no debe estar en blanco")
    private String provincia;

    @NotNull
    @NotBlank(message = "El distrito no debe estar en blanco")
    private String distrito;

    @NotNull
    @NotBlank(message = "La dirección no debe estar en blanco")
    private String direccion;

    //Descripción de las propiedades
    @NotNull
    @NotBlank(message = "La descripción no debe estar en blanco")
    private String descripcion;

    @NotNull
    @NotBlank(message = "Las otras comodidades no debe estar en blanco")
    private String otrasComodidades;

    @NotNull
    @NotBlank(message = "El tipo de propiedad no debe estar en blanco")
    private String tipoPropiedad;

    @NotNull
    @NotBlank(message = "El área del terreno no debe estar en blanco")
    private double areaTerreno;

    @NotNull
    @NotBlank(message = "El costo total no debe estar en blanco")
    private double costoTotal;

    @NotNull
    @NotBlank(message = "El costo inicial no debe estar en blanco")
    private double costoInicial;

    @NotNull
    private boolean cochera;

    @NotNull
    @NotBlank(message = "La cantidad de baños no debe estar en blanco")
    private int cantBanos;

    @NotNull
    @NotBlank(message = "La cantidad de dormitorios no debe estar en blanco")
    private int cantDormitorios;

    @NotNull
    @NotBlank(message = "La cantidad de cocheras no debe estar en blanco")
    private int cantCochera;
    
    private List<FotoDto> fotos;
}

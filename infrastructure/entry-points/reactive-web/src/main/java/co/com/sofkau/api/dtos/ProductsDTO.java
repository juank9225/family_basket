package co.com.sofkau.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO {
    private String id;
    private String codigo;
    private String nombre;
    private int precio;
    private int lote;


}

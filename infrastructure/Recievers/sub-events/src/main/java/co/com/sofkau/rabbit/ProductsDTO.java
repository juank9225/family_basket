package co.com.sofkau.rabbit;

import co.com.sofkau.model.products.Products;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductsDTO {
    private String id;
    private String codigo;
    private String nombre;
    private int precio;
    private int lote;

    public static ProductsDTO convertidorDominioADTO(Products products){
        return ProductsDTO.builder()
                .id(products.getId())
                .codigo(products.getCodigo())
                .nombre(products.getNombre())
                .precio(products.getPrecio())
                .lote(products.getLote())
                .build();
    }

    public static Products convertirDTOADominioCreacion(ProductsDTO productsDTO){
        return Products.builder()
                .id(productsDTO.getId())
                .codigo(productsDTO.getCodigo())
                .nombre(productsDTO.getNombre())
                .precio(productsDTO.getPrecio())
                .lote(productsDTO.getLote())
                .build();
    }

}

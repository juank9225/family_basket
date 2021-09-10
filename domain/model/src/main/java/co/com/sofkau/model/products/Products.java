package co.com.sofkau.model.products;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Products {
    private String id;
    private String codigo;
    private String nombre;
    private int precio;
    private int lote;
}

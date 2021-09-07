package co.com.sofkau.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class ProductsEntity {
    @Id
    private String id;
    private String codigo;
    private String nombre;
    private int precio;
    private int lote;

}

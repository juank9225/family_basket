package co.com.sofkau.model.products;
import lombok.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder(toBuilder = true)
public class Products {
    private String id;
    private String codigo;
    private String nombre;
    private int precio;
    private int lote;

    public Products() {
    }

    public Products(String id, String codigo, String nombre, int precio, int lote) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.lote = lote;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }
}

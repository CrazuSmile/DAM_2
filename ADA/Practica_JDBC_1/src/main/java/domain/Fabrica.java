package domain;

public class Fabrica {
    private int idFabrica;
    private String telefono;
    private int articulosProvistos;

    public Fabrica(int idFabrica, String telefono, int articulosProvistos) {
        this.idFabrica = idFabrica;
        this.telefono = telefono;
        this.articulosProvistos = articulosProvistos;
    }

    public Fabrica(int idFabrica) {
        this.idFabrica = idFabrica;
    }

    public Fabrica(String telefono, int articulosProvistos) {
        this.telefono = telefono;
        this.articulosProvistos = articulosProvistos;
    }

    public int getIdFabrica() {
        return idFabrica;
    }

    public void setIdFabrica(int idFabrica) {
        this.idFabrica = idFabrica;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getArticulosProvistos() {
        return articulosProvistos;
    }

    public void setArticulosProvistos(int articulosProvistos) {
        this.articulosProvistos = articulosProvistos;
    }

    @Override
    public String toString() {
        return "Fabrica: \nidFabrica: " + idFabrica + ", telefono: " + telefono + ", articulosProvistos: "
                + articulosProvistos;
    }

}

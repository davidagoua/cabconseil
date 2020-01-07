package prestation.client;

public class TypeClient {

    private Integer id;
    private String label;

    public TypeClient(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public TypeClient setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public TypeClient setLabel(String label) {
        this.label = label;
        return this;
    }
}

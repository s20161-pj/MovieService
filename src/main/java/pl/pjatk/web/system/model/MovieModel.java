package pl.pjatk.web.system.model;

public class MovieModel {
    private Long id;
    private String name;
    private EnCategory category;

    public MovieModel(Long id, String name, EnCategory category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EnCategory getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(EnCategory category) {
        this.category = category;
    }
}

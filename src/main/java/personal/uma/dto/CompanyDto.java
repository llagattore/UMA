package personal.uma.dto;

import java.util.List;

public class CompanyDto {

    private Integer id;
    private String name;
    private String description;
//    private List<UserDto> users; TO IMPLEMENT


    public CompanyDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

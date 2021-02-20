package dto;

public class TovarListDTO {
    private String name;
    private int id;
    private int cost;

    public TovarListDTO(){}
    public TovarListDTO(int id,String name, int cost){
        setId(id);
        setName(name);
        setCost(cost);
    }
    public TovarListDTO(String name,int cost){
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "TovarListDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", cost=" + cost +
                '}';
    }
}

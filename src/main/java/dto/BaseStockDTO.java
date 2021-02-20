package dto;

public class BaseStockDTO {
    private int id;
    private String name;
    private int amount;
    private int summa;
    private int cost;

    public BaseStockDTO(){}
    public BaseStockDTO(int id,String name, int amount, int summa){
        setId(id);
        setName(name);
        setAmount(amount);
        setSumma(summa);
    }
    public BaseStockDTO(int id,String name,int amount, int summa,int cost){
        this(id,name,amount,summa);
        setCost(cost);
    }
    public BaseStockDTO(String name,int amount){
        setName(name);
        setAmount(amount);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSumma() {
        return summa;
    }

    public void setSumma(int summa) {
        this.summa = summa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseStockDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + amount +
                ", summa=" + summa +
                '}';
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

package dto;

public class UserDTO {
    private int id;
    private String first_name;
    private String last_name;
    private String login;
    private String password;
    
    Scanner scanner = new Scanner(System.in);

    public UserDTO(){}
    public UserDTO(int id, String first_name, String last_name, String login, String password){
        this(first_name,last_name,login,password);
        setId(id);

    }

    public UserDTO(String first_name, String last_name, String login, String password){
        setFirst_name(first_name);
        setLast_name(last_name);
        setPassword(password);
        setLogin(login);
    }


    public void setFirst_name(String first_name){
        this.first_name=first_name;
    }
    public String getFirst_name(){
        return first_name;
    }

    public void setLast_name(String last_name){
        this.last_name=last_name;
    }
    public String getLast_name(){
        return last_name;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


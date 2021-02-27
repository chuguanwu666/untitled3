package domain;

public class Account {
    private Integer id;
    private String name;
    private  Double money;

    public static void main(String[] args) {
        System.out.println(Account.class.getClassLoader());
        System.out.println(ClassLoader.class);

    }

    public Integer getId() {
        return id;
    }

    public Account(Integer id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}

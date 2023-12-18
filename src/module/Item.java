package module;

public class Item {
    private String name;
    private int comboId;

    private int price;

    public Item(String name, int comboId) {
        this.name = name;
        this.comboId = comboId;
        this.price = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getComboId() {
        return comboId;
    }

    public void setComboId(int comboId) {
        this.comboId = comboId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

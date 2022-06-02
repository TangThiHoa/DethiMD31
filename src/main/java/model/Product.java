package model;

public class Product {
    private int id ;
    private String name ;
    private String color;
    private int quatity;
    private int price ;
    private Category categoryId;

    public Product() {
    }

    public Product( int id ,String name, String color, int quatity, int price, Category categoryId) {
        this.id = id ;
        this.name = name;
        this.color = color;

        this.quatity = quatity;
        this.price = price;
        this.categoryId = categoryId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }
}

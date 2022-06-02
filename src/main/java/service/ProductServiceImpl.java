package service;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
CategoryService categoryService ;
    protected Connection getConnection() {
        Connection connection = null;
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/product2001?useSSL=false", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");) {
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String color = rs.getString("color");
                int quatity = rs.getInt("quatity");
                int price = rs.getInt("price");
                int categoryId = rs.getInt("categoryId");
                Category category= categoryService.findById(categoryId);
                products.add(new Product(id,name,color,quatity,price,category));

            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public void add(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into product(name,color,quantity,price,categoryId) values (?, ?,?,?,?)");) {
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getColor());
            preparedStatement.setInt(3, product.getQuatity());
            preparedStatement.setInt(4, product.getCategoryId().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    @Override
    public Product findById(int id) {
        Product products = new Product();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String color = rs.getString("color");
                int quatity = rs.getInt("quatity");
                int price = rs.getInt("price");
                int categoryId = rs.getInt("categoryId");
                Category category= categoryService.findById(categoryId);
                products = new Product(id,name,color,quatity,price,category);

            }
        } catch (SQLException e) {
        }
        return products;
    }


    @Override
    public boolean update(Product product) throws SQLException {
        boolean a = false;
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("update product set name =?,color=?,quantity=?,price=?,categoryId=? where id=?");) {
             preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getColor());
            preparedStatement.setInt(3, product.getQuatity());
            preparedStatement.setInt(4, product.getCategoryId().getId());
            a = preparedStatement.executeUpdate() > 0;

        }
        return a;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }
}

import java.sql.*;

public class hello {

    static String table;
    static String primaryKey;
    static Connection connection;

    public static void getAll() throws SQLException {
        String sql = "SELECT * FROM customers; ";
        System.out.println("sql");

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setUsername(rs.getString("username"));
            customer.setLast_name(rs.getString("last_name"));
            customer.setFirst_name(rs.getString("first_name"));
            customer.setPhone(rs.getString("phone"));
            customer.setAddress(rs.getString("address"));
            customer.setCity(rs.getString("city"));
            customer.setPostalCode(rs.getString("postalCode"));
            customer.setCountry(rs.getString("country"));
            System.out.println(customer.toString());
        }
    }

    public static void getById(int id) throws SQLException {
        String sql = "SELECT * FROM customers WHERE id = " + id + "; ";
        System.out.println("sql");

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()){
        Customer c1 = new Customer();
        c1.setId(rs.getInt("id"));
        c1.setUsername(rs.getString("username"));
        c1.setFirst_name(rs.getString("first_name"));
        c1.setLast_name(rs.getString("last_name"));
        c1.setPhone(rs.getString("phone"));
        c1.setAddress(rs.getString("address"));
        c1.setCity(rs.getString("city"));
        c1.setPostalCode(rs.getString("postalCode"));
        c1.setCountry(rs.getString("country"));
        System.out.println(c1.toString());
        }

    }

    public static void insert(Customer customer) throws SQLException {

        String sql = "INSERT INTO customers (id,username, first_name, last_name, phone, address, city, postalCode, country) VALUES (0,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        System.out.println(sql);

        ps.setString(1, customer.getUsername());
        ps.setString(2, customer.getFirst_name());
        ps.setString(3, customer.getLast_name());
        ps.setString(4, customer.getPhone());
        ps.setString(5, customer.getAddress());
        ps.setString(6, customer.getCity());
        ps.setString(7, customer.getPostalCode());
        ps.setString(8, customer.getCountry());

        ps.execute();

    }

    public static void delete(int id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

    public static void update(int id, Customer customer) throws SQLException{
        String sql = "UPDATE customers SET username = ?," +
                "first_name = ?," + "last_name = ?," +
                "phone = ?," + "address = ?,"
                + "city = ?," +  "postalCode = ?," +
                "country = ? WHERE id = ?;";


        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, customer.getUsername());
        ps.setString(2, customer.getFirst_name());
        ps.setString(3, customer.getLast_name());
        ps.setString(4, customer.getPhone());
        ps.setString(5, customer.getAddress());
        ps.setString(6, customer.getCity());
        ps.setString(7, customer.getPostalCode());
        ps.setString(8, customer.getCountry());
        ps.setInt(9, id);

        ps.execute();
    }

    public static void addOrder(Order order, int id) throws SQLException {
        String sql = "INSERT INTO orders (id, order_date, shipped_date, status, comments, customer_id) VALUES (0,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        System.out.println(sql);

        ps.setDate(1, order.getOrder_date());
        ps.setDate(2, order.getShipped_date());
        ps.setString(3, order.getStatus());
        ps.setString(4, order.getComments());
        ps.setInt(5, id);


        ps.execute();
    }

    public static void viewAllOrders(int id) throws SQLException {
        String sql = "SELECT * FROM orders WHERE customer_id = " + id + "; ";
        System.out.println("sql");

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {
            Order o = new Order();
            o.setId_order(rs.getInt("id"));
            o.setOrder_date(rs.getDate("order_date"));
            o.setShipped_date(rs.getDate("shipped_date"));
            o.setStatus(rs.getString("status"));
            o.setComments(rs.getString("comments"));
            o.setComments(rs.getString("comments"));
            o.setCustomer_id(id);

            System.out.println(o.toString());
        }
    }

    public static void updateCommentOrder(int id, String newCom) throws SQLException {
        String sql = "UPDATE orders SET comments = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1,newCom);
        ps.setInt(2, id);

        ps.execute();
    }

    public static void updateStatusOrder(int id, String newStatus) throws SQLException {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1,newStatus);
        ps.setInt(2, id);

        ps.execute();
    }

    public static void main(String[] args) throws SQLException {

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/tema_4";
        String username = "root";
        String password = "admin";
        connection = DriverManager.getConnection(connectionUrl, username, password);

        Customer c1 = new Customer(1,"redsnack", "Mihai", "Banica", "12312312312", "camin", "Bucuresti","234", "Ughanda");
        insert(c1);
        delete(5);
        getAll();
        Customer c2 = new Customer(1,"bluesnack", "Mihai", "Banica", "12312312312", "camin", "Bucuresti","234", "Ughanda");
        update(1, c2);
        getById(1);
        Order o1 = new Order(1,Date.valueOf("2020-05-02"), Date.valueOf("2032-10-10"), "delivered", "na", 1);
        addOrder(o1, o1.getCustomer_id());
        viewAllOrders(1);
    }
}

import java.sql.Date;

public class Order {
    private int id_order;
    private Date order_date;
    private Date shipped_date;
    private String status;
    private String comments;
    private int customer_id;

    public Order(){}

    public Order(int id_order, Date order_date, Date shipped_date, String status, String comments, int customer_id) {
        this.id_order = id_order;
        this.order_date = order_date;
        this.shipped_date = shipped_date;
        this.status = status;
        this.comments = comments;
        this.customer_id = customer_id;
    }

    public int getId_order() {
        return id_order;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Date getShipped_date() {
        return shipped_date;
    }

    public String getStatus() {
        return status;
    }

    public String getComments() {
        return comments;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public void setShipped_date(Date shipped_date) {
        this.shipped_date = shipped_date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id_order=" + id_order +
                ", order_date=" + order_date +
                ", shipped_date=" + shipped_date +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", customer_id=" + customer_id +
                '}';
    }
}

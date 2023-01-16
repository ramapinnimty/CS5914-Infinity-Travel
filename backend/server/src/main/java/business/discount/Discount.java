package business.discount;

import java.util.Date;

public class Discount {
    private int discount_id;
    private String discountCode;
    private int percentage;
    private Date creationDate;
    private Boolean utilized;

    public Discount(int discount_id, String discountCode, int percentage, Date creationDate, Boolean utilized) {
        this.discount_id = discount_id;
        this.discountCode = discountCode;
        this.percentage = percentage;
        this.creationDate = creationDate;
        this.utilized = utilized;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getUtilized() {
        return utilized;
    }

    public void setUtilized(Boolean utilized) {
        this.utilized = utilized;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discount_id=" + discount_id +
                ", discountCode='" + discountCode + '\'' +
                ", percentage=" + percentage +
                ", creationDate=" + creationDate +
                ", utilized=" + utilized +
                '}';
    }
}

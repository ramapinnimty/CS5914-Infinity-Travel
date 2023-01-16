package business.discount;

public interface DiscountDAO extends DAO<Discount> {
    Discount getByCode(String discount_code);
}

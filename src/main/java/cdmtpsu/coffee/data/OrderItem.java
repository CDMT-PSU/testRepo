package cdmtpsu.coffee.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Objects;

@DatabaseTable(tableName = OrderItem.TABLE_NAME)
public final class OrderItem implements DataObject {
    /* names */
    public static final String TABLE_NAME = "order_item";
    public static final String ORDER_FIELD_NAME = "order_id";
    public static final String MENU_ITEM_FIELD_NAME = "menu_item_id";
    public static final String AMOUNT_FIELD_NAME = "amount";
    /* indices */
    public static final int ORDER_FIELD_INDEX = 0;
    public static final int MENU_ITEM_FIELD_INDEX = 1;
    public static final int AMOUNT_FIELD_INDEX = 2;

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = ORDER_FIELD_NAME, foreign = true, foreignAutoRefresh = true)
    private Order order;
    @DatabaseField(columnName = MENU_ITEM_FIELD_NAME, foreign = true, foreignAutoRefresh = true)
    private MenuItem menuItem;
    @DatabaseField(columnName = AMOUNT_FIELD_NAME)
    private int amount;

    public OrderItem() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public Object getValue(int fieldIndex) {
        switch (fieldIndex) {
            case ORDER_FIELD_INDEX:
                return order;
            case MENU_ITEM_FIELD_INDEX:
                return menuItem;
            case AMOUNT_FIELD_INDEX:
                return amount;
            default:
                return null;
        }
    }

    @Override
    public void setValue(int fieldIndex, Object value) {
        switch (fieldIndex) {
            case ORDER_FIELD_INDEX:
                order = (Order) value;
                break;
            case MENU_ITEM_FIELD_INDEX:
                menuItem = (MenuItem) value;
                break;
            case AMOUNT_FIELD_INDEX:
                amount = (int) value;
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem that = (OrderItem) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order +
                ", menuItem=" + menuItem +
                ", amount=" + amount +
                '}';
    }
}

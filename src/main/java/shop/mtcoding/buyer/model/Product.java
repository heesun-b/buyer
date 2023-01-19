package shop.mtcoding.buyer.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.buyer.util.DateUtil;

@Getter
@Setter
public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;
    private Timestamp createdAt;

    public String getcreatedAtToString() {
        return DateUtil.format(createdAt);
    };
}

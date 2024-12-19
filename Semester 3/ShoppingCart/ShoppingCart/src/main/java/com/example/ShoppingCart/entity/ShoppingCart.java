package com.example.ShoppingCart.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;




/*@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
*/

@Entity
@Setter
@Getter
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int productId;
    private String productName;

    private int quantity;
    private float amount;

    public ShoppingCart() {
    }

    public ShoppingCart(int productId, String productName, int quantity, float amount) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.amount = amount;
    }

    public ShoppingCart(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}

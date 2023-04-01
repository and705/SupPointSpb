package com.nd705.suppointspb.entity.shop;

import com.nd705.suppointspb.entity.User;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "orders")
public class Order {
    private static final String SEQ_NAME = "order_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    @ManyToOne //у пользователя много заказов
    @JoinColumn(name = "user_id")
    private User user;
    private BigDecimal sum;
    private String adress;
    @OneToMany(cascade = CascadeType.ALL) //у заказа множество деталей
    private List<OrderDetails> details;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


}

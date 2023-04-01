package com.nd705.suppointspb.entity.booking;

import com.nd705.suppointspb.entity.User;
import com.nd705.suppointspb.entity.shop.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "bookings")
public class Booking {
    private static final String SEQ_NAME = "booking_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    @ManyToOne //у несколько заказов
    @JoinColumn(name = "user_id")
    private User user;
    private BigDecimal sum;
    @OneToMany(cascade = CascadeType.ALL) //у заказа множество деталей
    private List<BookingDetails> details;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}

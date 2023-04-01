package com.nd705.suppointspb.entity.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "booking_details")
public class BookingDetails {
    private static final String SEQ_NAME = "booking_details_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "booking_id") //обр
    private Booking booking;
    @ManyToOne
    @JoinColumn(name = "Timetable_id")
    private Timetable timetable;
    private BigDecimal amount;
    private BigDecimal price;
}

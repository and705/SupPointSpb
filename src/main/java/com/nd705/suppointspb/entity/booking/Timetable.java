package com.nd705.suppointspb.entity.booking;

import com.nd705.suppointspb.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "timetables")
public class Timetable {
    private static final String SEQ_NAME = "timetable_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private LocalDate date;
    private LocalTime time;
    @OneToOne
    private Route route;
    private int places;
    private int availablePlaces;
    @OneToOne
    private User user;
    private String comment;
    private String photoLink;

}

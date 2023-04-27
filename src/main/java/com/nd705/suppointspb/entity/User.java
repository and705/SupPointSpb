package com.nd705.suppointspb.entity;

import com.nd705.suppointspb.entity.shop.Bucket;
import com.nd705.suppointspb.entity.shop.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "users")
public class User {
    private static final String SEQ_NAME = "user_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private String tgId;
    private String tgName;
    private String comment;
    private boolean archive;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Bucket bucket;

}

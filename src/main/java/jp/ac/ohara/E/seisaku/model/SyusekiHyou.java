package jp.ac.ohara.E.seisaku.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
 
@Data
@Entity
@Table(name="syusekihyou")
public class SyusekiHyou {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name="syuketu",length = 8, nullable = false)
    private String syuketu;

    @Column(name="syuseki",nullable = false)
    private LocalDateTime syuseki;
    
    @Column(name="studentnumber",length = 64, nullable = false)
    private String studentnumber;
}
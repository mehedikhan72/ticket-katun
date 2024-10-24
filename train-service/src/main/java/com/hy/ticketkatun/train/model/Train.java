package com.hy.ticketkatun.train.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "train")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Train {
    @Id
    private String id;
    private String name;
    private String source;
    private String destination;
    private Integer ticketsRemaining;
}

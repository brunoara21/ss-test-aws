package com.ss.testing_aws.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="RESTAURANT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)", name = "restaurantId", updatable = false)
    private UUID restaurantId;

	@NotBlank
    private String name;

    @Builder.Default
    private Float rating = 0.f;


    @Builder.Default
    @Column(name="isActive")
    private Boolean isActive = true;
    

}

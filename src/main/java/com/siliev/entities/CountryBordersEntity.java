package com.siliev.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "country_borders", schema = "public", catalog = "efbet")
@IdClass(CompositeKey.class)
public class CountryBordersEntity {

    @Id
    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    @Id
    @Column(name = "country_border_code")
    private String countryBorderCode;

    @Column(name = "country_border_name")
    private String countryBorderName;

    @Column(name = "country_currency_code")
    private String countyCurrencyIsoCode;

}

package com.ezio.springdataelasticsearch.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-09-03 13:54
 */
@Data
@Document(indexName = "province", type = "city")
public class CityDocument implements Serializable {

    @Id
    private Long id;

    private String name;

    private String description;

    private Integer score;

}

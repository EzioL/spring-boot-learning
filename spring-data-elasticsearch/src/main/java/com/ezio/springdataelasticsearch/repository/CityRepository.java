package com.ezio.springdataelasticsearch.repository;

import com.ezio.springdataelasticsearch.domain.CityDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-09-03 13:56
 * @desc: 简单的crud示例
 */
@Repository
public interface CityRepository extends ElasticsearchRepository<CityDocument, Long> {

    // TAG: Ezio 2019-09-03 一些 类似jpa的命名方法

    /**
     * AND
     * @param description
     * @param score
     * @return
     */
    List<CityDocument> findByDescriptionAndScore(String description, Integer score);


    /**
     * OR
     * @param description
     * @param score
     * @return
     */
    List<CityDocument> findByDescriptionOrScore(String description, Integer score);

    /**
     * 查询城市描述
     * 等同于下面代码
     * @Query("{\"bool\" : {\"must\" : {\"term\" : {\"description\" : \"?0\"}}}}")
     * Page<City> findByDescription(String description, Pageable pageable);
     * @param description
     * @param page
     * @return
     */
    Page<CityDocument> findByDescription(String description, Pageable page);

    /**
     * NOT 语句查询
     *
     * @param description
     * @param page
     * @return
     */
    Page<CityDocument> findByDescriptionNot(String description, Pageable page);

    /**
     * LIKE 语句查询
     *
     * @param description
     * @param page
     * @return
     */
    Page<CityDocument> findByDescriptionLike(String description, Pageable page);



}

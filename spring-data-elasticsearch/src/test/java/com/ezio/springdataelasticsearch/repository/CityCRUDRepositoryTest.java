package com.ezio.springdataelasticsearch.repository;

import com.ezio.springdataelasticsearch.domain.CityDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-09-03 14:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CityCRUDRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    private static final Integer pageNumber = 0;
    private static final Integer pageSize = 10;
    Pageable pageable = PageRequest.of(pageNumber, pageSize);


    @Test
    public void test_save() {
        CityDocument city = new CityDocument();
        city.setId(1L);
        city.setName("上海");
        city.setScore(3);
        city.setDescription("上海是个好城市");
        cityRepository.save(city);

        CityDocument city2 = new CityDocument();
        city2.setId(2L);
        city2.setName("北京");
        city2.setScore(4);
        city2.setDescription("北京是首都");
        cityRepository.save(city2);

    }

    @Test
    public void test_update() {
        cityRepository.findById(2L).ifPresent(e -> {
            e.setName(e.getName()+"_update"+"_"+System.currentTimeMillis());
            cityRepository.save(e);
            System.out.println(cityRepository.findById(2L).orElse(null));
        });
    }

    @Test
    public void findByDescriptionAndScore() {
        System.out.println(cityRepository.findByDescriptionAndScore("北京是首都", 4));
    }

    @Test
    public void findByDescriptionOrScore() {
        System.out.println(cityRepository.findByDescriptionOrScore("北京是首都", 3));
    }

    @Test
    public void findByDescription() {
        System.out.println(cityRepository.findByDescription("北京是首都", pageable).getContent());
    }

    @Test
    public void findByDescriptionNot() {
        System.out.println(cityRepository.findByDescriptionNot("北京是首都", pageable).getContent());
    }

    @Test
    public void findByDescriptionLike() {
        System.out.println(cityRepository.findByDescriptionLike("北京是首都", pageable).getContent());

    }
}

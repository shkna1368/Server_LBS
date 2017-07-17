package com.shabab.lbsserver;


import com.shabab.lbsserver.model.Place;
import com.shabab.lbsserver.model.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import javax.sql.DataSource;
import java.util.List;


@SpringBootApplication
public class Application   implements CommandLineRunner  {

    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    DataSource dataSource;
   // PlaceDaoService repository;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);


    }
       @Override
        public void run(String... args) throws Exception {
          // List<Place> list = placeRepository.findAll();
           List<Place> list = placeRepository.findNearest(35.298900,46.990131);
           System.out.println("List size="+list.size());
         //  System.out.println("List size="+list.get(0).toString());
           list.forEach(x -> System.out.println(x.toString(x.getDistance()) ));


           System.out.println("-----------------------------");

          // List<Place> list2 = placeRepository.findNearesInRadious(35.298900,46.990131,1000);
          /* List<Place> list2 = placeRepository.findNearesInRadious(35.2988736 ,46.9894574,1000);
           System.out.println("List size with radious="+list2.size());
           //  System.out.println("List size="+list.get(0).toString());
           list2.forEach(x -> System.out.println(x.toString(x.getDistance()) ));*/


    }
}

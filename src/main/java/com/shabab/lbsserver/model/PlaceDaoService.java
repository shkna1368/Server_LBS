/*
package com.shabab.lbsserver.model;

import org.postgis.Geometry;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

*/
/**
 * Created by Sh-Java on 6/28/2017.
 *//*


@Transactional
public interface PlaceDaoService  extends PagingAndSortingRepository<Place, Long> {

    List<Place> findByPlaceID(long placeID);

   // @Query("select place from Place place where  u.price <= :price")
 */
/*  static final String HAVERSINE_PART ="ST_Distance_Sphere( place.geo, st_setsrid(st_makepoint( :lon,:lat),4326))";
    @Query("select place from Place AS place where "+HAVERSINE_PART)
    List<Place> findNearestPlace(@Param("lat") double lat, @Param("lon") double lon);
*//*

 public String query="SELECT place_name,lat, lon,tpes,ST_Distance_Sphere(geo, st_setsrid(st_makepoint( 35.311423, 46.996114),4326)) as distance " +
           "FROM sanandaj_place " +

           "ORDER BY distance"
         ;


 @Query(value =query,nativeQuery = true)
 @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
    List<Place> findNearestPlace(@Param("lat") double lat, @Param("lon") double lon);







  */
/*  @Query("SELECT d FROM place AS d WHERE within(d.location, :polygon) = TRUE")
    List<Device> findWithin(@Param("polygon") Polygon polygon);*//*


      */
/*@Query("SELECT place_name,lat, lon,tpes,ST_Distance_Sphere(geo, st_setsrid(st_makepoint( 46.967017,35.321639),4326)) as distance\n" +
              "FROM sanandaj_place\n" +
              "\n" +
              "ORDER BY distance\n"
              )
    List<Place> findNearestPlaces(@Param("lat") double lat, @Param("lon") double lon);

*//*

   */
/* SELECT *
    FROM your_table
    WHERE ST_Distance_Sphere(the_geom, ST_MakePoint(your_lon,your_lat)) <= radius_mi * 1609.34

    ST_Distance_Sphere(geo, st_setsrid(st_makepoint( 46.967017,35.321639),4326)) as distance
    ST_Distance_Sphere(geo, st_setsrid(st_makepoint( 46.967017,35.321639),4326)) as distance*//*










}
*/

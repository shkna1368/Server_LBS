package com.shabab.lbsserver.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sh-Java on 6/29/2017.
 */
@Repository
public class PlaceRepository {

    private final String INSERT_SQL = "INSERT INTO sanandaj_place(name,address,email) values(?,?,?)";
    private final String FETCH_SQL = "select * from sanandaj_place";
    private final String FETCH_SQL_BY_ID = "select * from sanandaj_place where place_id = ?";
    /*private final String FETCH_BY_DISTANCE = "SELECT plc_id,place_name,lat, place_descryption,lon,tpes ,ST_Distance_Sphere(geo, st_setsrid(st_makepoint(?,?),4326)) as dst " +
            "FROM sanandaj_place " +

            "ORDER BY dst " +
            "LIMIT 10";*/


     private final String FETCH_BY_DISTANCE = "SELECT *, dst" +
             " FROM sanandaj_place as sp ,ST_Distance_Sphere(geo, st_setsrid(st_makepoint(?,?),4326)) as dst " +

            "ORDER BY dst " +
            "LIMIT 10";




/*  private final String FETCH_BY_DISTANCE__RADIOUS = "SELECT *,ST_Distance_Sphere(geo, st_setsrid(st_makepoint(?,?),4326)) as dst " +
          " FROM sanandaj_place " +
          " WHERE dst <= ? " +
          " ORDER BY dst";*/

 private final String FETCH_BY_DISTANCE__RADIOUS = "SELECT *, dst" +
          " FROM sanandaj_place as sp, ST_Distance_Sphere(geo, st_setsrid(st_makepoint(?,?),4326)) as dst " +
          " WHERE dst <= ? " +
          " ORDER BY dst";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Find all customers, thanks Java 8, you can create a custom RowMapper like this :
    public List<Place> findAll() {


            return jdbcTemplate.query(FETCH_SQL, new UserMapper());



    }


    public List<Place> findNearest(double lat,double lon) {


            return jdbcTemplate.query(FETCH_BY_DISTANCE, new Object[] {lon,lat},new UserMapper());



    }

 public List<Place> findNearesInRadious(double lat,double lon,double radious) {


            return jdbcTemplate.query(FETCH_BY_DISTANCE__RADIOUS, new Object[] {lon,lat,radious},new UserMapper());



    }




    // Add new customer
    public void addCustomer(String name, String email) {

     /*   jdbcTemplate.update("INSERT INTO customer(name, email, created_date) VALUES (?,?,?)",
                name, email, new Date());*/

    }

    class UserMapper implements RowMapper {

        @Override
        public Place mapRow(ResultSet rs, int rowNum) throws SQLException {


       /*     SELECT place_name,lat, lon,tpes,ST_Distance_Sphere(geo, st_setsrid(st_makepoint( 46.967017,35.321639),4326)) as distance
            FROM sanandaj_place
*/

            Place p = new Place();
            p.setPlaceID(rs.getLong("plc_id"));
            p.setLon(rs.getDouble("lon"));
            p.setLat(rs.getDouble("lat"));
            p.setType(rs.getString("tpes"));
            p.setDistance(rs.getDouble("dst"));
            p.setPlaceName(rs.getString("place_name"));
            p.setPlaceDescrption(rs.getString("place_descryption"));

            return p;
        }
    }

}

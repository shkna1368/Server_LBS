package com.shabab.lbsserver.model;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Type;
import org.postgis.Geometry;

import javax.persistence.*;

/**
 * Created by Sh-Java on 6/27/2017.
 */


@Entity
@Table(name ="sanandaj_place")
public class Place {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plc_id")
private long placeID;

    @Column(name = "lat")
    private double lat;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Column(name = "lon")
    private double lon;


    @Transient
    private double distance;

   // private double distance;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "place_descryption")
    private String placeDescrption;

  /*  @Type(type = "org.hibernate.spatial.GeometryType")
    @Column(name = "geo")
    private Geometry geo;*/

    @Column(name = "tpes")
    private String type;

    public long getPlaceID() {
        return placeID;
    }

    public void setPlaceID(long placeID) {
        this.placeID = placeID;
    }

   /* public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
*/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceDescrption() {
        return placeDescrption;
    }

    public void setPlaceDescrption(String placeDescrption) {
        this.placeDescrption = placeDescrption;
    }




    public String toString(double distance){

        return   "Latitute:"+lat+'\n'+
          "Longitude:"+lon+'\n'+
          "Distance:"+distance+'\n'+
        "PlaceName:"+placeName+'\n'+
       "PlacceDescryption:"+placeDescrption+'\n'+
       "type:"+type+'\n';


    }
}

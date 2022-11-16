package miniProject.accountBook.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "place_name")
    String placeName;
    @Column(name = "place_url")
    String placeUrl;
    @Column(name = "road_address_name")
    String roadAddressName;
    String x;
    String y;
    Date date;
}

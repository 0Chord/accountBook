package miniProject.accountBook.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LocationDto {
    private String placeName;
    private String x;
    private String y;
    private String placeUrl;
    private String roadAddressName;
    private Date date;

    public Date getDate() {
        Date date = new Date();
        return date;
    }
}

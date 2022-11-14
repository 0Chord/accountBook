package miniProject.accountBook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Document {
    @JsonProperty("address_name")
    private String addressName;
    @JsonProperty("category_group_code")
    private String categoryGroupCode;
    @JsonProperty("category_group_name")
    private String categoryGroupName;
    @JsonProperty("category_name")
    private String categoryName;
    private Long distance;
    private String id;
    private String phone;
    @JsonProperty("place_name")
    private String placeName;
    @JsonProperty("place_url")
    private String placeUrl;
    @JsonProperty("road_address_name")
    private String roadAddressName;
    private String x;
    private String y;

    public Document() {
    }

    public Document(String addressName, String categoryGroupCode, String categoryGroupName, String categoryName, Long distance, String id, String phone, String placeName, String placeUrl, String roadAddressName, String x, String y) {
        this.addressName = addressName;
        this.categoryGroupCode = categoryGroupCode;
        this.categoryGroupName = categoryGroupName;
        this.categoryName = categoryName;
        this.distance = distance;
        this.id = id;
        this.phone = phone;
        this.placeName = placeName;
        this.placeUrl = placeUrl;
        this.roadAddressName = roadAddressName;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Document{" +
                "addressName='" + addressName + '\'' +
                ", categoryGroupCode='" + categoryGroupCode + '\'' +
                ", categoryGroupName='" + categoryGroupName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", distance=" + distance +
                ", id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", placeName='" + placeName + '\'' +
                ", placeUrl='" + placeUrl + '\'' +
                ", roadAddressName='" + roadAddressName + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }
}

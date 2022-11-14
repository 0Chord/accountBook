package miniProject.accountBook.dto;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class LocationInfo {
    private Document[] documents;
    private Meta meta;

    public LocationInfo() {
    }

    public LocationInfo(Document[] document, Meta meta) {
        this.documents = document;
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "documents=" + Arrays.toString(documents) +
                ", meta=" + meta +
                '}';
    }
}

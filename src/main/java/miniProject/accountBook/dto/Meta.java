package miniProject.accountBook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Meta {
    @JsonProperty("is_end")
    private Boolean isEnd;
    @JsonProperty("pageable_count")
    private Long pageableCount;
    @JsonProperty("same_name")
    private SameName sameName;
    @JsonProperty("total_count")
    private Long totalCount;

    public Meta() {
    }

    public Meta(Boolean isEnd, Long pageableCount, SameName sameName, Long totalCount) {
        this.isEnd = isEnd;
        this.pageableCount = pageableCount;
        this.sameName = sameName;
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "isEnd=" + isEnd +
                ", pageableCount=" + pageableCount +
                ", sameName=" + sameName +
                ", totalCount=" + totalCount +
                '}';
    }
}

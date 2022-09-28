package miniProject.accountBook.account;

import java.util.Date;

public class Account {
    String id;
    String item;
    Long price;
    Long export_sum;
    Long import_sum;
    Long sum;
    Date date;

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getExport_sum() {
        return export_sum;
    }

    public void setExport_sum(Long export_sum) {
        this.export_sum = export_sum;
    }

    public Long getImport_sum() {
        return import_sum;
    }

    public void setImport_sum(Long import_sum) {
        this.import_sum = import_sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

package by.courses.java.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Roll {

    @Value("SuperVendor")
    private String vendor;

    public Roll() {
    }

    public Roll(String vendor) {
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Roll{");
        sb.append("vendor='").append(vendor).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package capstone.bcs.lifo.model;

import javafx.util.converter.PercentageStringConverter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

public class Coupons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coupon_id;
    private String couponType;
    private String couponCode;
    private int coupon_percent;
    private Date coupon_start;
    private Date coupon_end;
    private int uses_per_coupon;
    private boolean coupon_active;
    private int uses_per_user;

    @CreatedDate
    private Date date_created;

    @LastModifiedDate
    private Date date_modified;

    public int getCoupon_id() {
        return coupon_id;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public int getCoupon_percent() {
        return coupon_percent;
    }

    public void setCoupon_percent(int coupon_percent) {
        this.coupon_percent = coupon_percent;
    }

    public Date getCoupon_start() {
        return coupon_start;
    }

    public void setCoupon_start(Date coupon_start) {
        this.coupon_start = coupon_start;
    }

    public Date getCoupon_end() {
        return coupon_end;
    }

    public void setCoupon_end(Date coupon_end) {
        this.coupon_end = coupon_end;
    }

    public int getUses_per_coupon() {
        return uses_per_coupon;
    }

    public void setUses_per_coupon(int uses_per_coupon) {
        this.uses_per_coupon = uses_per_coupon;
    }

    public boolean isCoupon_active() {
        return coupon_active;
    }

    public void setCoupon_active(boolean coupon_active) {
        this.coupon_active = coupon_active;
    }

    public int getUses_per_user() {
        return uses_per_user;
    }

    public void setUses_per_user(int uses_per_user) {
        this.uses_per_user = uses_per_user;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Date date_modified) {
        this.date_modified = date_modified;
    }
}

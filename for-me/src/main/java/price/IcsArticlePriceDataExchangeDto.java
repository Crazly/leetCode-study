package price;

import java.math.BigDecimal;
import java.util.Date;

public class IcsArticlePriceDataExchangeDto {
    private Long id;
//    private String createdBy;
//    private Date dateCreated;
//    private Date dateUpdated;
//    private String updatedBy;
//    private Integer optCounter;
//    private BigDecimal cost;
//    private String failReason;
//    private String original;
//    private Date reissueTime;
//    private String skuDesc;
//    private String shopNo;

//    private String skuNo;
//
//    private String skuName;
//    private String remarks;
//
//    private BigDecimal originalPrice;

    private BigDecimal salesPrice;
//    private String skuStatus;
//    private Double tax;
//    private String transmitResult;
//    private String transmitStatus;
//    private Date transmitTime;
//    private String unit;
//    private Date updateTime;
//    private String channelNo;
//    private String allowDis;
//    private String saleOrg;
//    private String taxPoint;
//    private String deleteFlag;
    private Date effectiveTime;

    private String effectiveTimeStr;
    private Date endTime;

    private String endTimeStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getEffectiveTimeStr() {
        return effectiveTimeStr;
    }

    public void setEffectiveTimeStr(String effectiveTimeStr) {
        this.effectiveTimeStr = effectiveTimeStr;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }
}

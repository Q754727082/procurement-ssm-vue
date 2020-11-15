package com.dataset.entity;

import java.io.Serializable;

/**
 * (Zhaobiao)实体类
 *
 * @author makejava
 * @since 2020-09-06 14:52:30
 */
public class Zhaobiao implements Serializable {
    private static final long serialVersionUID = -25249412099456245L;
    /**
     * ID编号
     */
    private Integer id;
    /**
     * 公告名称
     */
    private String announcementName;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 地址
     */
    private String address;
    /**
     * 时间
     */
    private String time;
    /**
     * 采购人
     */
    private String buyer;
    /**
     * 品目
     */
    private String item;
    /**
     * 采购单位
     */
    private String purchasingUnit;
    /**
     * 行政区域
     */
    private String administrative;
    /**
     * 公告时间
     */
    private String announcementTime;
    /**
     * 评审专家名单
     */
    private String expert;
    /**
     * 总中标金额
     */
    private String amount;
    /**
     * 项目联系人
     */
    private String contactPerson;
    /**
     * 项目联系电话
     */
    private String contactNumber;
    /**
     * 采购单位
     */
    private String xPurchasingUnit;
    /**
     * 采购单位地址
     */
    private String unitAddress;
    /**
     * 采购单位联系方式
     */
    private String unitContact;
    /**
     * 代理机构名称
     */
    private String nameOfAgent;
    /**
     * 代理机构地址
     */
    private String agencyAddress;
    /**
     * 代理机构联系方式
     */
    private String agentContact;
    /**
     * 类型
     */
    private String annoType;
    /**
     * 链接地址
     */
    private String url;
    /**
     * 获取招标文件时间
     */
    private String tenderTime;
    /**
     * 招标文件售价
     */
    private String documentPrice;
    /**
     * 获取招标文件的地点
     */
    private String placeTender;
    /**
     * 开标时间
     */
    private String openingTime;
    /**
     * 开标地点
     */
    private String openingPlace;
    /**
     * 预算金额
     */
    private String budgetAmount;
    /**
     * 获取采购文件时间
     */
    private String purchasingTime;
    /**
     * 获取采购文件的地点
     */
    private String placePurchase;
    /**
     * 提交文件截止时间
     */
    private String documentDeadline;
    /**
     * 资格预审日期
     */
    private String prequalificationTime;
    /**
     * 首次公告日期
     */
    private String firstDate;
    /**
     * 更正日期
     */
    private String correctionDate;
    /**
     * 响应文件递交地点
     */
    private String resSubmissionLocation;
    /**
     * 响应文件开启时间
     */
    private String resFileTime;
    /**
     * 响应文件开启地点
     */
    private String resOpeningLocation;
    /**
     * 评审专家（单一来源采购人员）名单
     */
    private String singlePerson;
    /**
     * 总成交金额
     */
    private String totalAmount;
    /**
     * 更正事项
     */
    private String corrections;
    /**
     * 政府1/地方2
     */
    private String governmentLocal;
    /**
     * 公告信息信息
     */
    private String gxxText;

   /* *//**
     * 省份&城市
     *//*
    private String area1;*/

    public Zhaobiao() {
    }

    public Zhaobiao(Integer id, String announcementName, String projectName, String address, String time, String buyer, String item, String purchasingUnit, String administrative, String announcementTime, String expert, String amount, String contactPerson, String contactNumber, String xPurchasingUnit, String unitAddress, String unitContact, String nameOfAgent, String agencyAddress, String agentContact, String type, String url, String tenderTime, String documentPrice, String placeTender, String openingTime, String openingPlace, String budgetAmount, String purchasingTime, String placePurchase, String documentDeadline, String prequalificationTime, String firstDate, String correctionDate, String resSubmissionLocation, String resFileTime, String resOpeningLocation, String singlePerson, String totalAmount, String corrections, String governmentLocal, String gxxText, String area1) {
        this.id = id;
        this.announcementName = announcementName;
        this.projectName = projectName;
        this.address = address;
        this.time = time;
        this.buyer = buyer;
        this.item = item;
        this.purchasingUnit = purchasingUnit;
        this.administrative = administrative;
        this.announcementTime = announcementTime;
        this.expert = expert;
        this.amount = amount;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
        this.xPurchasingUnit = xPurchasingUnit;
        this.unitAddress = unitAddress;
        this.unitContact = unitContact;
        this.nameOfAgent = nameOfAgent;
        this.agencyAddress = agencyAddress;
        this.agentContact = agentContact;
        this.annoType = annoType;
        this.url = url;
        this.tenderTime = tenderTime;
        this.documentPrice = documentPrice;
        this.placeTender = placeTender;
        this.openingTime = openingTime;
        this.openingPlace = openingPlace;
        this.budgetAmount = budgetAmount;
        this.purchasingTime = purchasingTime;
        this.placePurchase = placePurchase;
        this.documentDeadline = documentDeadline;
        this.prequalificationTime = prequalificationTime;
        this.firstDate = firstDate;
        this.correctionDate = correctionDate;
        this.resSubmissionLocation = resSubmissionLocation;
        this.resFileTime = resFileTime;
        this.resOpeningLocation = resOpeningLocation;
        this.singlePerson = singlePerson;
        this.totalAmount = totalAmount;
        this.corrections = corrections;
        this.governmentLocal = governmentLocal;
        this.gxxText = gxxText;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnnouncementName() {
        return announcementName;
    }

    public void setAnnouncementName(String announcementName) {
        this.announcementName = announcementName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPurchasingUnit() {
        return purchasingUnit;
    }

    public void setPurchasingUnit(String purchasingUnit) {
        this.purchasingUnit = purchasingUnit;
    }

    public String getAdministrative() {
        return administrative;
    }

    public void setAdministrative(String administrative) {
        this.administrative = administrative;
    }

    public String getAnnouncementTime() {
        return announcementTime;
    }

    public void setAnnouncementTime(String announcementTime) {
        this.announcementTime = announcementTime;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getxPurchasingUnit() {
        return xPurchasingUnit;
    }

    public void setxPurchasingUnit(String xPurchasingUnit) {
        this.xPurchasingUnit = xPurchasingUnit;
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress;
    }

    public String getUnitContact() {
        return unitContact;
    }

    public void setUnitContact(String unitContact) {
        this.unitContact = unitContact;
    }

    public String getNameOfAgent() {
        return nameOfAgent;
    }

    public void setNameOfAgent(String nameOfAgent) {
        this.nameOfAgent = nameOfAgent;
    }

    public String getAgencyAddress() {
        return agencyAddress;
    }

    public void setAgencyAddress(String agencyAddress) {
        this.agencyAddress = agencyAddress;
    }

    public String getAgentContact() {
        return agentContact;
    }

    public void setAgentContact(String agentContact) {
        this.agentContact = agentContact;
    }

    public String getAnnoType() {
        return annoType;
    }

    public void setAnnoType(String annoType) {
        this.annoType = annoType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTenderTime() {
        return tenderTime;
    }

    public void setTenderTime(String tenderTime) {
        this.tenderTime = tenderTime;
    }

    public String getDocumentPrice() {
        return documentPrice;
    }

    public void setDocumentPrice(String documentPrice) {
        this.documentPrice = documentPrice;
    }

    public String getPlaceTender() {
        return placeTender;
    }

    public void setPlaceTender(String placeTender) {
        this.placeTender = placeTender;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getOpeningPlace() {
        return openingPlace;
    }

    public void setOpeningPlace(String openingPlace) {
        this.openingPlace = openingPlace;
    }

    public String getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(String budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public String getPurchasingTime() {
        return purchasingTime;
    }

    public void setPurchasingTime(String purchasingTime) {
        this.purchasingTime = purchasingTime;
    }

    public String getPlacePurchase() {
        return placePurchase;
    }

    public void setPlacePurchase(String placePurchase) {
        this.placePurchase = placePurchase;
    }

    public String getDocumentDeadline() {
        return documentDeadline;
    }

    public void setDocumentDeadline(String documentDeadline) {
        this.documentDeadline = documentDeadline;
    }

    public String getPrequalificationTime() {
        return prequalificationTime;
    }

    public void setPrequalificationTime(String prequalificationTime) {
        this.prequalificationTime = prequalificationTime;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getCorrectionDate() {
        return correctionDate;
    }

    public void setCorrectionDate(String correctionDate) {
        this.correctionDate = correctionDate;
    }

    public String getResSubmissionLocation() {
        return resSubmissionLocation;
    }

    public void setResSubmissionLocation(String resSubmissionLocation) {
        this.resSubmissionLocation = resSubmissionLocation;
    }

    public String getResFileTime() {
        return resFileTime;
    }

    public void setResFileTime(String resFileTime) {
        this.resFileTime = resFileTime;
    }

    public String getResOpeningLocation() {
        return resOpeningLocation;
    }

    public void setResOpeningLocation(String resOpeningLocation) {
        this.resOpeningLocation = resOpeningLocation;
    }

    public String getSinglePerson() {
        return singlePerson;
    }

    public void setSinglePerson(String singlePerson) {
        this.singlePerson = singlePerson;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCorrections() {
        return corrections;
    }

    public void setCorrections(String corrections) {
        this.corrections = corrections;
    }

    public String getGovernmentLocal() {
        return governmentLocal;
    }

    public void setGovernmentLocal(String governmentLocal) {
        this.governmentLocal = governmentLocal;
    }

    public String getGxxText() {
        return gxxText;
    }

    public void setGxxText(String gxxText) {
        this.gxxText = gxxText;
    }

    @Override
    public String toString() {
        return "Zhaobiao{" +
                "id=" + id +
                ", announcementName='" + announcementName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", address='" + address + '\'' +
                ", time='" + time + '\'' +
                ", buyer='" + buyer + '\'' +
                ", item='" + item + '\'' +
                ", purchasingUnit='" + purchasingUnit + '\'' +
                ", administrative='" + administrative + '\'' +
                ", announcementTime='" + announcementTime + '\'' +
                ", expert='" + expert + '\'' +
                ", amount='" + amount + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", xPurchasingUnit='" + xPurchasingUnit + '\'' +
                ", unitAddress='" + unitAddress + '\'' +
                ", unitContact='" + unitContact + '\'' +
                ", nameOfAgent='" + nameOfAgent + '\'' +
                ", agencyAddress='" + agencyAddress + '\'' +
                ", agentContact='" + agentContact + '\'' +
                ", annoType='" + annoType + '\'' +
                ", url='" + url + '\'' +
                ", tenderTime='" + tenderTime + '\'' +
                ", documentPrice='" + documentPrice + '\'' +
                ", placeTender='" + placeTender + '\'' +
                ", openingTime='" + openingTime + '\'' +
                ", openingPlace='" + openingPlace + '\'' +
                ", budgetAmount='" + budgetAmount + '\'' +
                ", purchasingTime='" + purchasingTime + '\'' +
                ", placePurchase='" + placePurchase + '\'' +
                ", documentDeadline='" + documentDeadline + '\'' +
                ", prequalificationTime='" + prequalificationTime + '\'' +
                ", firstDate='" + firstDate + '\'' +
                ", correctionDate='" + correctionDate + '\'' +
                ", resSubmissionLocation='" + resSubmissionLocation + '\'' +
                ", resFileTime='" + resFileTime + '\'' +
                ", resOpeningLocation='" + resOpeningLocation + '\'' +
                ", singlePerson='" + singlePerson + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", corrections='" + corrections + '\'' +
                ", governmentLocal='" + governmentLocal + '\'' +
                ", gxxText='" + gxxText + '\'' +
                '}';
    }
}
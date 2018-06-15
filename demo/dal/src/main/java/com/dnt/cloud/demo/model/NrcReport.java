package com.dnt.cloud.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商户报表数据实体
 * 
 * @author hazyhao
 *
 */
public class NrcReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1210192350379512618L;

	/**
	 * 商户名称
	 */
	private String merchantName;
	/**
	 * 商户Id
	 */
	private Long merchantId;
	/**
	 * 区域Id
	 */
	private Long regionId;
	/**
	 * 区域名称
	 */
	private String regionName;
	/**
	 * 门店Id
	 */
	private Long storeId;
	/**
	 * 门店名称
	 */
	private String storeName;
	/**
	 * 设备Id
	 */
	private Long deviceId;
	/**
	 * 设备名称
	 */
	private String deviceName;
	/**
	 * 商品Id
	 */
	private Long spuId;
	/**
	 * 商品名称
	 */
	private String spuName;
	/**
	 * 点击量
	 */
	private Integer flowData;
	/**
	 * 下单量
	 */
	private Integer orderData;
	/**
	 * 支付量
	 */
	private Integer payData;
	/**
	 * 转化率
	 */
	private Integer conversionRates;
	/**
	 * 支付金额
	 */
	private BigDecimal payAmout;

	/**
	 * 统计时间
	 */
	private Date statisticsDate;

	/**
	 * 统计时间-小时
	 */
	private String statisticsHour;
	/**
	 * 查询标记
	 */
	private String queryTimeFlag;

	private String visitType;

	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getVisitType() {
		return visitType;
	}

	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getFlowData() {
		return flowData;
	}

	public void setFlowData(Integer flowData) {
		this.flowData = flowData;
	}

	public Integer getOrderData() {
		return orderData;
	}

	public void setOrderData(Integer orderData) {
		this.orderData = orderData;
	}

	public Integer getPayData() {
		return payData;
	}

	public void setPayData(Integer payData) {
		this.payData = payData;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Integer getConversionRates() {
		return conversionRates;
	}

	public void setConversionRates(Integer conversionRates) {
		this.conversionRates = conversionRates;
	}

	public BigDecimal getPayAmout() {
		return payAmout;
	}

	public void setPayAmout(BigDecimal payAmout) {
		this.payAmout = payAmout;
	}

	public Date getStatisticsDate() {
		return statisticsDate;
	}

	public void setStatisticsDate(Date statisticsDate) {
		this.statisticsDate = statisticsDate;
	}

	public String getStatisticsHour() {
		return statisticsHour;
	}

	public void setStatisticsHour(String statisticsHour) {
		this.statisticsHour = statisticsHour;
	}

	public String getQueryTimeFlag() {
		return queryTimeFlag;
	}

	public void setQueryTimeFlag(String queryTimeFlag) {
		this.queryTimeFlag = queryTimeFlag;
	}

	public String getSpuName() {
		return spuName;
	}

	public void setSpuName(String spuName) {
		this.spuName = spuName;
	}

	public Long getSpuId() {
		return spuId;
	}

	public void setSpuId(Long spuId) {
		this.spuId = spuId;
	}

}

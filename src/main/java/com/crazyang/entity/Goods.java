package com.crazyang.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Goods
 * @Description: 商品信息实体类
 * @Author zhouyang
 * @Date 2019/3/8 下午3:55.
 */
@Table(name = "goods")
public class Goods {

    /**
     * 商品ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goodsId;
    /**
     * 商品编号
     */
    private String goodsSn;
    /**
     *商品货号
     */
    private String productNo;
    /**
     *商品名称
     */
    private String goodsName;
    /**
     *商品图片
     */
    private String goodsImg;
    /**
     *市场价
     */
    private Double marketPrice;
    /**
     *门店价
     */
    private Double shopPrice;
    /**
     *预警库存
     */
    private int warnStock;
    /**
     *商品总库存
     */
    private int goodsStock;
    /**
     *是否上架
     */
    private int sale;
    /**
     *是否精品
     */
    private int best;
    /**
     *是否热销产品
     */
    private int hot;
    /**
     *删除标志
     */
    private int dataFlag;
    /**
     *创建时间
     */
    @Column(name="create_time")
    private Date createTime;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public int getWarnStock() {
        return warnStock;
    }

    public void setWarnStock(int warnStock) {
        this.warnStock = warnStock;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getBest() {
        return best;
    }

    public void setBest(int best) {
        this.best = best;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(int dataFlag) {
        this.dataFlag = dataFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

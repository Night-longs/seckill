package org.seckill.entity;

import java.util.Date;
import java.util.zip.DataFormatException;

public class SuccessKilled {
    private Long seckillId;  //秒杀商品id
    private Long userPhone;  //用户手机号
    private Short state;  //用户秒杀商品状态
    private Date CreateTime; //用户秒杀商品时间
    private Seckill seckill; // 多对一,因为一件商品在库存中有很多数量，对应的购买明细也有很多。

    public SuccessKilled() {
    }

    public SuccessKilled(Long seckillId, Long userPhone, Short state, Date createTime, Seckill seckill) {
        this.seckillId = seckillId;
        this.userPhone = userPhone;
        this.state = state;
        CreateTime = createTime;
        this.seckill = seckill;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", CreateTime=" + CreateTime +
                ", seckill=" + seckill +
                '}';
    }
}

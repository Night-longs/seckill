package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务接口：站在“使用者” 角度设计接口
 * 三个方面： 方法定义粒度，参数，返回类型（return 类型/异常）
 */

public interface SeckillService {

    /**
     * 拆查询全部秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);


    /**
     * 在秒杀开启时输出秒杀接口的地址，否则输出系统时间和系统时间
     *
     * @param seckillId seckillId 秒杀商品Id
     * @return 根据对应的状态返回对应的实体
     */
    //void exportSeckillUrl(long seckillId);
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作，有可能失败，有可能成功，所以我们要抛出我们允许的异常
     * @param seckillId 秒杀商品的id
     * @param userPhone  手机号码
     * @param md5           md5加密值
     * @return        根据不同的结果返回不同的实体信息
     */
    SeckillExecution excuteSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException;

    /**
     *
     * 执行秒杀操作 by  存储过程
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws RepeatKillException
     * @throws SeckillCloseException
     */
    SeckillExecution excuteSeckillProcedure(long seckillId, long userPhone, String md5) ;
}

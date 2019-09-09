package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置sqpring和junit整合,junit启动时加载springIOC容器
 * spring-text junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() {
        Date killTime=new Date();
       int updateCount=seckillDao.reduceNumber(1000L,killTime);
        System.out.println(updateCount);
    }

    @Test
    /**
     *
     */
    public void queryById() {

        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);

    }

    /**
     * Seckill{seckillid=null, name='1000元秒杀iphonex', number=null, createTime=Mon Aug 19 00:53:32 CST 2019, startTime=Fri Nov 01 08:00:00 CST 2019, endTime=Sat Nov 02 08:00:00 CST 2019}
     * Seckill{seckillid=null, name='500元秒杀ipad2', number=null, createTime=Mon Aug 19 00:53:32 CST 2019, startTime=Fri Nov 01 08:00:00 CST 2019, endTime=Sat Nov 02 08:00:00 CST 2019}
     * Seckill{seckillid=null, name='300元秒杀小米9', number=null, createTime=Mon Aug 19 00:53:32 CST 2019, startTime=Fri Nov 01 08:00:00 CST 2019, endTime=Sat Nov 02 08:00:00 CST 2019}
     * Seckill{seckillid=null, name='200元秒杀红米note', number=null, createTime=Mon Aug 19 00:53:32 CST 2019, startTime=Fri Nov 01 08:00:00 CST 2019, endTime=Sat Nov 02 08:00:00 CST 2019}
     */
    @Test
    public void queryAll() {
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckills
        ) {
            System.out.println(seckill);

        }
    }
}
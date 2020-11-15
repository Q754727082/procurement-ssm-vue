package com.dataset.test;

import com.dataset.entity.Zhaobiao;
import com.dataset.service.ZhaobiaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


//业务层测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ZhaoBiaoTest {
    @Autowired
    private ZhaobiaoService zhaobiaoService;

    @Test
    public void testSelectTenByLucene() throws Exception{
        List<Zhaobiao> zhaobiaos = zhaobiaoService.selectTenByLucene("广州");
        System.out.println(zhaobiaos);
    }

    @Test
    public void testSelectByLucene() throws Exception{
        List<Zhaobiao> zhaobiaos=zhaobiaoService.selectByLucene("广东污水");
        System.out.println(zhaobiaos);
    }

    @Test
    public void testFind(){
        Zhaobiao zhaobiao = zhaobiaoService.queryById(3001);
        System.out.println(zhaobiao);
    }

    @Test
    public void testSelectTen(){
        List<Zhaobiao> zhaobiaos = zhaobiaoService.selectTen(0);
        System.out.println(zhaobiaos);
    }

    @Test
    public void testFindTen(){
        List<Zhaobiao> zhaobiaos1=zhaobiaoService.findTen();
        System.out.println(zhaobiaos1);
    }

    @Test
    public void testSelectSimpleMessage(){
        List<Zhaobiao> zhaobiaos2=zhaobiaoService.selectSimpleMessage(0);
        System.out.println(zhaobiaos2);
    }

    @Test
    public void testQueryByFix(){
        List<Zhaobiao> zhaobiaos3=zhaobiaoService.queryByFix("广东",null,"180","工程");
        System.out.println(zhaobiaos3);
    }

    @Test
    public void testSelectByFix(){
        List<Zhaobiao> zhaobiaos7=zhaobiaoService.selectByFix("广东",null,"180",0,"系统");
        System.out.println(zhaobiaos7);
    }

    @Test
    public void testQueryByKeyword(){
        List<Zhaobiao> zhaobiaos4=zhaobiaoService.queryByKeyword("污水");
        System.out.println(zhaobiaos4);
    }

    @Test
    public void testFindByKeyword(){
        List<Zhaobiao> zhaobiaos5=zhaobiaoService.findByKeyword("污水");
        System.out.println(zhaobiaos5);
    }

    @Test
    public void testSelectByKeyword(){
        List<Zhaobiao> zhaobiaos6=zhaobiaoService.selectByKeyword("污水",10);
        System.out.println(zhaobiaos6);
    }
}

package com.dataset.controller;

import com.dataset.entity.Zhaobiao;
import com.dataset.service.ZhaobiaoService;
import com.dataset.util.BaseResponse;
import com.dataset.util.StatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Zhaobiao)表控制层
 *
 * @author makejava
 * @since 2020-09-06 14:52:31
 */
@RestController
@RequestMapping("zhaobiao")
public class ZhaobiaoController {
    /**
     * 服务对象
     */
    @Resource
    private ZhaobiaoService zhaobiaoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Zhaobiao selectOne(Integer id) {
        return this.zhaobiaoService.queryById(id);
    }


    //查询所有
    @RequestMapping("selectAll")
    public List<Zhaobiao> selectAll(){
        return zhaobiaoService.queryAllNoLimit();
    }

    //查询所有json格式数据
    @RequestMapping("findAll")
    public List<Zhaobiao> findAll(){
        return zhaobiaoService.findAll();
    }

    //每次查询十条记录
    @RequestMapping("selectTen")
    public List<Zhaobiao> selectTen(int pageNo){
        return zhaobiaoService.selectTen(pageNo);
    }

    //查询初始数据
    @RequestMapping("findTen")
    public List<Zhaobiao> findTen(){
        return zhaobiaoService.findTen();
    }

    //每次查询十条Json数据
    @RequestMapping("selectTenJson")
    public List<Zhaobiao> selectTenJson(int pageNo){
        return zhaobiaoService.selectTenJson(pageNo);
    }

    //查询30条简单信息放在主页
    @RequestMapping("findSimpleMessage")
    public List<Zhaobiao> findSimpleMessage(){
        return zhaobiaoService.findSimpleMessage();
    }

    //每次查询10条简单信息放在主页
    @RequestMapping("selectSimpleMessage")
    public List<Zhaobiao> selectSimpleMessage(int pageNo){
        return zhaobiaoService.selectSimpleMessage(pageNo);
    }

    //多条件查询
    @RequestMapping("queryByFix")
    public BaseResponse queryByFix(String address, String annoType, String day,String keyword){
        List<Zhaobiao> zhaobiaos=zhaobiaoService.queryByFix(address,annoType,day,keyword);
        if (zhaobiaos !=null && zhaobiaos.size()>0){
            BaseResponse response=new BaseResponse(StatusCode.Success);
            response.setList(zhaobiaos);
            return response;
        }else {
            BaseResponse response=new BaseResponse(StatusCode.Fail);
            return response;
        }
    }

    @RequestMapping("selectByFix")
    public List<Zhaobiao> selectByFix(String address,String annoType,String day,int pageNo,String keyword){
        return zhaobiaoService.selectByFix(address,annoType, day,pageNo,keyword);
    }

    //根据关键字模糊查询
    @RequestMapping("queryByKeyword")
    public List<Zhaobiao> queryByKeyword(String keyword){
        return zhaobiaoService.queryByKeyword(keyword);
    }

    //根据关键字模糊查询初始30条记录
    @RequestMapping("findByKeyword")
    public List<Zhaobiao> findByKeyword(String keyword){
        return zhaobiaoService.findByKeyword(keyword);
    }

    //根据关键字每次模糊查询十条记录
    @RequestMapping("selectByKeyword")
    public List<Zhaobiao> selectByKeyword(String keyword,int pageNo){
        return zhaobiaoService.selectByKeyword(keyword,pageNo);
    }

    //根据关键字使用lucene查询十条记录
    @RequestMapping("selectTenByLucene")
    public List<Zhaobiao> selectTenByLucene(String keyword) throws Exception{
        return zhaobiaoService.selectTenByLucene(keyword);
    }

    //使用lucene根据关键字分词查询所有记录
    @RequestMapping("selectByLucene")
    public List<Zhaobiao> selectByLucene(String keyword) throws Exception{
        return zhaobiaoService.selectByLucene(keyword);
    }

}
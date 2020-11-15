package com.dataset.service;

import com.dataset.entity.Zhaobiao;

import java.util.List;

/**
 * (Zhaobiao)表服务接口
 *
 * @author makejava
 * @since 2020-09-06 14:52:31
 */
public interface ZhaobiaoService {

    //查询所有
    List<Zhaobiao> queryAllNoLimit();

    //用lucene模糊查询十条
    List<Zhaobiao> selectTenByLucene(String keyword) throws Exception;

    //使用lucene根据关键字分词查询所有记录
    List<Zhaobiao> selectByLucene(String keyword) throws Exception;


    //查询所有 json格式的数据
    List<Zhaobiao> findAll();

    //每次查询10条记录
    List<Zhaobiao> selectTen(int pageNo);

    //查询10条记录
    List<Zhaobiao> findTen();


    //查询10条json数据
    List<Zhaobiao> selectTenJson(int pageNo);

    //查询30条简单信息放在主页
    List<Zhaobiao> findSimpleMessage();

    //每次查询10条简单信息放在主页
    List<Zhaobiao> selectSimpleMessage(int pageNo);

    /**
     *
     * @param address 地区
     * @param annoType  公告类型
     * @param day   查询几天内
     * @return
     */
    List<Zhaobiao> queryByFix(String address,String annoType,String day,String keyword);

    /**
     * 三个条件混合查询，每次十个记录
     * @param address 地区
     * @param annoType  公告类型
     * @param day   查询几天内
     * @param pageNo  跳过的记录数
     * @return
     */
    List<Zhaobiao> selectByFix(String address,String annoType,String day,int pageNo,String keyword);


    /**
     * 根据关键字模糊查询
     * @param keyword
     * @return
     */
    List<Zhaobiao> queryByKeyword(String keyword);


    /**
     * 根据关键字模糊查询初始30条记录
     * @param keyword 关键字
     * @return
     */
    List<Zhaobiao> findByKeyword(String keyword);

    /**
     * 根据关键字每次模糊查询十条记录
     * @param keyword 关键字
     * @param pageNo  跳过的记录数
     * @return
     */
    List<Zhaobiao> selectByKeyword(String keyword,int pageNo);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Zhaobiao queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Zhaobiao> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param zhaobiao 实例对象
     * @return 实例对象
     */
    Zhaobiao insert(Zhaobiao zhaobiao);

    /**
     * 修改数据
     *
     * @param zhaobiao 实例对象
     * @return 实例对象
     */
    Zhaobiao update(Zhaobiao zhaobiao);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
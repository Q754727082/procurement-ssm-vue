package com.dataset.dao;

import com.dataset.entity.Zhaobiao;
import net.sf.jsqlparser.statement.select.Offset;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Zhaobiao)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-06 14:52:31
 */
public interface ZhaobiaoDao {


    //查询所有
    List<Zhaobiao> queryAllNoLimit();

    //查询10条json数据
    List<Zhaobiao> selectTenJson(int pageNo);

    //查询所有 json格式的数据
    List<Zhaobiao> findAll();

    //滚动到底部每次查询10条记录
    List<Zhaobiao> selectTen(int pageNo);

    //页面初始化查询10条记录
    List<Zhaobiao> findTen();

    //查询30条简单信息放在主页
    List<Zhaobiao> findSimpleMessage();

    //每次查询10条简单信息放在主页
    List<Zhaobiao> selectSimpleMessage(int pageNo);

    /**
     *四个条件混合查询
     * @param keyword 关键字
     * @param address 地区
     * @param annoType  公告类型
     * @param day   查询几天内
     * @return
     */
    List<Zhaobiao> queryByFix(@Param("address")String address,@Param("annoType") String annoType,@Param("day") String day, @Param("keyword") String keyword);

    /**
     * 四个条件混合查询，每次十个记录
     * @param keyword 关键字
     * @param address 地区
     * @param annoType  公告类型
     * @param day   查询几天内
     * @param pageNo  跳过的记录数
     * @return
     */
    List<Zhaobiao> selectByFix(@Param("address")String address,@Param("annoType") String annoType,@Param("day") String day,@Param("pageNo")int pageNo, @Param("keyword") String keyword);

    /**
     * 根据关键字模糊查询所有
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
    List<Zhaobiao> selectByKeyword(@Param("keyword") String keyword,@Param("pageNo") int pageNo);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Zhaobiao queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Zhaobiao> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param zhaobiao 实例对象
     * @return 对象列表
     */
    List<Zhaobiao> queryAll(Zhaobiao zhaobiao);

    /**
     * 新增数据
     *
     * @param zhaobiao 实例对象
     * @return 影响行数
     */
    int insert(Zhaobiao zhaobiao);

    /**
     * 修改数据
     *
     * @param zhaobiao 实例对象
     * @return 影响行数
     */
    int update(Zhaobiao zhaobiao);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
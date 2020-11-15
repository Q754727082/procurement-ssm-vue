package com.dataset.service.impl;

import com.dataset.dao.ZhaobiaoDao;
import com.dataset.entity.Zhaobiao;
import com.dataset.service.ZhaobiaoService;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * (Zhaobiao)表服务实现类
 *
 * @author makejava
 * @since 2020-09-06 14:52:31
 */
@Service("zhaobiaoService")
public class ZhaobiaoServiceImpl implements ZhaobiaoService {
    @Resource
    private ZhaobiaoDao zhaobiaoDao;

    @Override
    public List<Zhaobiao> selectTenByLucene(String keyword) throws Exception {
        Directory directory = FSDirectory.open(new File("E:\\SSM+VUE\\procurement\\index").toPath());
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        Query query = new TermQuery(new Term("announcementName", keyword));
        TopDocs topDocs = indexSearcher.search(query, 10);
        ScoreDoc[] docs = topDocs.scoreDocs;
        List<Zhaobiao> zhaobiaos = new ArrayList<>();
        for (ScoreDoc doc : docs) {
            int docId = doc.doc;
            Document document = indexSearcher.doc(docId);
            Zhaobiao zhaobiao = new Zhaobiao();
            zhaobiao.setAnnouncementName(document.get("announcementName"));
            zhaobiaos.add(zhaobiao);
        }
        indexReader.close();
        return zhaobiaos;
    }

    @Override
    public List<Zhaobiao> selectByLucene(String keyword) throws Exception {
        Directory directory = FSDirectory.open(new File("E:\\SSM+VUE\\procurement\\index").toPath());
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        QueryParser queryParser = new QueryParser("announcementName", new IKAnalyzer());
        Query query = queryParser.parse(keyword);
        TopDocs topDocs = indexSearcher.search(query, 1000);
        ScoreDoc[] docs = topDocs.scoreDocs;
        List<Zhaobiao> zhaobiaos = new ArrayList<>();
        for (ScoreDoc doc : docs) {
            int docId = doc.doc;
            Document document = indexSearcher.doc(docId);
            Zhaobiao zhaobiao = new Zhaobiao();
            zhaobiao.setAnnouncementName(document.get("announcementName"));
            zhaobiao.setTime(document.get("time"));
            zhaobiao.setId(Integer.parseInt(document.get("id")));
            zhaobiao.setAdministrative(document.get("administrative"));
            zhaobiao.setAnnoType(document.get("annoType"));
            zhaobiaos.add(zhaobiao);
        }
        indexReader.close();
        return zhaobiaos;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Zhaobiao queryById(Integer id) {
        return this.zhaobiaoDao.queryById(id);
    }

    @Override
    public List<Zhaobiao> queryAllNoLimit() {
        return zhaobiaoDao.queryAllNoLimit();
    }

    @Override
    public List<Zhaobiao> findSimpleMessage() {
        return zhaobiaoDao.findSimpleMessage();
    }

    @Override
    public List<Zhaobiao> selectSimpleMessage(int pageNo) {
        return zhaobiaoDao.selectSimpleMessage(pageNo);
    }

    @Override
    public List<Zhaobiao> selectTenJson(int pageNo) {
        return zhaobiaoDao.selectTenJson(pageNo);
    }

    @Override
    public List<Zhaobiao> findTen() {
        return zhaobiaoDao.findTen();
    }

    @Override
    public List<Zhaobiao> selectTen(int pageNo) {
        return zhaobiaoDao.selectTen(pageNo);
    }

    @Override
    public List<Zhaobiao> findAll() {
        return zhaobiaoDao.findAll();
    }

    @Override
    public List<Zhaobiao> queryByFix(String address, String annotype, String day,String keyword) {
        return zhaobiaoDao.queryByFix(address,annotype,day,keyword);
    }

    @Override
    public List<Zhaobiao> selectByFix(String address, String annoType, String day, int pageNo,String keyword) {
        return zhaobiaoDao.selectByFix(address,annoType,day,pageNo,keyword);
    }

    @Override
    public List<Zhaobiao> queryByKeyword(String keyword) {
        return zhaobiaoDao.queryByKeyword(keyword);
    }

    @Override
    public List<Zhaobiao> findByKeyword(String keyword) {
        return zhaobiaoDao.findByKeyword(keyword);
    }



    @Override
    public List<Zhaobiao> selectByKeyword(String keyword, int pageNo) {
        return zhaobiaoDao.selectByKeyword(keyword,pageNo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Zhaobiao> queryAllByLimit(int offset, int limit) {
        return this.zhaobiaoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param zhaobiao 实例对象
     * @return 实例对象
     */
    @Override
    public Zhaobiao insert(Zhaobiao zhaobiao) {
        this.zhaobiaoDao.insert(zhaobiao);
        return zhaobiao;
    }

    /**
     * 修改数据
     *
     * @param zhaobiao 实例对象
     * @return 实例对象
     */
    @Override
    public Zhaobiao update(Zhaobiao zhaobiao) {
        this.zhaobiaoDao.update(zhaobiao);
        return this.queryById(zhaobiao.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.zhaobiaoDao.deleteById(id) > 0;
    }
}
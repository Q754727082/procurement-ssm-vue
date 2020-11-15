package com.dataset.test;

import com.dataset.entity.Zhaobiao;
import com.dataset.service.ZhaobiaoService;
import com.dataset.service.impl.ZhaobiaoServiceImpl;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.junit.experimental.results.PrintableResult;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wltea.analyzer.lucene.IKAnalyzer;


import java.io.File;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class IndexManagerTest {
    @Autowired
    private ZhaobiaoService zhaobiaoService;

    @Test
    public void createIndex() throws Exception{
        FSDirectory directory = FSDirectory.open(new File("E:\\index").toPath());
        IndexWriterConfig config = new IndexWriterConfig(new IKAnalyzer());
        IndexWriter indexWriter = new IndexWriter(directory, config);
        List<Zhaobiao> zhaobiaos=zhaobiaoService.findAll();
        for (Zhaobiao zhaobiao : zhaobiaos) {
            Field fieldId = new StoredField("id", zhaobiao.getId()+"");
            Field fieldTime = new StoredField("time", zhaobiao.getTime()+"");
            Field fieldAdministrative = new StoredField("administrative", zhaobiao.getAdministrative()+"");
            Field fieldAnnoType = new StoredField("annoType", zhaobiao.getAnnoType()+"");
            Field fieldAnnouncementName = new TextField("announcementName", zhaobiao.getAnnouncementName(), Field.Store.YES);
            Document document = new Document();
            document.add(fieldId);
            document.add(fieldAnnouncementName);
            document.add(fieldTime);
            document.add(fieldAdministrative);
            document.add(fieldAnnoType);
            indexWriter.addDocument(document);
        }
        indexWriter.close();
    }

    @Test
    public void searchIndex() throws Exception{
        Directory directory = FSDirectory.open(new File("E:\\index").toPath());
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        Query query=new TermQuery(new Term("announcementName","广东"));
        TopDocs topDocs = indexSearcher.search(query, 10);
        System.out.println("查询总记录数："+topDocs.totalHits);
        ScoreDoc[] docs = topDocs.scoreDocs;
        for (ScoreDoc doc : docs) {
            int docId = doc.doc;
            Document document = indexSearcher.doc(docId);
            System.out.println(document.get("announcementName"));
            System.out.println(document.get("id"));
            System.out.println("-------------------");
        }
        indexReader.close();
    }
    @Test
    public void testQueryParser() throws Exception{
        Directory directory = FSDirectory.open(new File("E:\\index").toPath());
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        QueryParser queryParser = new QueryParser("announcementName", new IKAnalyzer());
        Query query = queryParser.parse("北京污水");
        TopDocs topDocs = indexSearcher.search(query, 10);
        System.out.println("查询总记录数："+topDocs.totalHits);
        ScoreDoc[] docs = topDocs.scoreDocs;
        for (ScoreDoc doc : docs) {
            int docId = doc.doc;
            Document document = indexSearcher.doc(docId);
            System.out.println(document.get("announcementName"));
            System.out.println(document.get("id"));
            System.out.println("-------------------");
        }
        indexReader.close();
    }
}
import org.apache.lucene.codecs.FieldsProducer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Author: zouxiang
 * Date: 2019/12/23
 * Description: No Description
 */
public class IndexWriterTest {
    @Test
    public void testIndexWriter() throws IOException {
        Directory directory = FSDirectory.open(Paths.get("D:\\elasticsearch-env\\lucene-test-dir\\1"));
        IndexWriterConfig iwc = new IndexWriterConfig();
        iwc.setUseCompoundFile(false);
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

        IndexWriter indexWriter = new IndexWriter(directory, iwc);

        Document document = new Document();
        document.add(new TextField("name", "hello world", Field.Store.YES));

        indexWriter.addDocument(document);

        indexWriter.commit();
        indexWriter.close();
    }

    @Test
    public void testIndexReader() throws IOException {
        Directory directory = FSDirectory.open(Paths.get("D:\\elasticsearch-env\\lucene-test-dir\\1"));
        DirectoryReader indexReader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(indexReader);
        TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 1);
        int docId = topDocs.scoreDocs[0].doc;
        Document document = searcher.doc(docId);
        System.out.println(document);
    }

    @Test
    public void test1() throws IOException {
        //
        /*
        Terms & TermsEnum & PostingsEnum
        Terms表示一个field中所有的term
        TermsEnum用于迭代一个Terms(按字典序)
        PostingsEnum表示一个Term的倒排表 (在哪些文档中出现过)
         */
        Directory directory = FSDirectory.open(Paths.get("D:\\elasticsearch-env\\lucene-test-dir\\1"));
        StandardDirectoryReader indexReader = (StandardDirectoryReader) DirectoryReader.open(directory);
        SegmentReader segmentReader = (SegmentReader) indexReader.leaves().get(0).reader();

        FieldsProducer postingsReader = segmentReader.getPostingsReader();
        Terms terms = postingsReader.terms("name");
        TermsEnum termsEnum = terms.iterator();
        System.out.println(termsEnum.next().utf8ToString());
        boolean found = termsEnum.seekExact(new BytesRef("hello"));
        System.out.println("是否找到? " + found);
        PostingsEnum postings = termsEnum.postings(null);
        int docId;
        while (true) {
            docId = postings.nextDoc(); // 迭代到下一个文档，并返回docId
            int freq = postings.freq(); // 当前文档中出现了多少次
            for (int i = 0; i < freq; i++) {
                int position = postings.nextPosition(); // 下一次出现在哪个位置;
                // 获取该位置上的 offsets & payloads
                int startOffset = postings.startOffset();
                int endOffset = postings.endOffset();
                BytesRef payload = postings.getPayload();
            }
        }
    }

    @Test
    public void testTermQuery() throws IOException {
        Directory directory = FSDirectory.open(Paths.get("D:\\elasticsearch-env\\lucene-test-dir\\1"));
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(indexReader);

        TopDocs topDocs = searcher.search(new TermQuery(new Term("name", "hello")), 10);
        System.out.println(topDocs);

        Explanation explain = searcher.explain(new TermQuery(new Term("name", "hello")), 0);
        System.out.println(explain);


    }
}

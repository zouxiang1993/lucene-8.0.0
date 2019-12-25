import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
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
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);

        IndexWriter indexWriter = new IndexWriter(directory, iwc);

        Document document = new Document();
        document.add(new TextField("name", "啊啊啊", Field.Store.YES));

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
}

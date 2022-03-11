package ro.ase.cts.nosql;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import ro.ase.cts.contract.ExpressionNOSQL;

public class ReadData implements ExpressionNOSQL {
    @Override
    public void expression(MongoCollection<Document> collection) {
        FindIterable<Document> result = collection.find();
        for(Document doc : result) {
            System.out.println(doc);
        }
    }
}

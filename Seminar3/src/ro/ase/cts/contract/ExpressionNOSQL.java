package ro.ase.cts.contract;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public interface ExpressionNOSQL {
    void expression(MongoCollection<Document> collection);
}

package ro.ase.cts.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ro.ase.cts.contract.ExpressionNOSQL;

public class CreateTable implements ExpressionNOSQL {
    @Override
    public void expression(MongoCollection<Document> collection) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDb = mongoClient.getDatabase("test");
        if (mongoDb.getCollection("employees") != null) {
            mongoDb.getCollection("employees").drop();
        }

        mongoDb.createCollection("employees");
    }
}

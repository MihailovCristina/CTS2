package ro.ase.cts.orchestrators;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ro.ase.cts.contract.ExpressionNOSQL;

public class OrchestratorNOSQL {
    private final ExpressionNOSQL create;
    private final ExpressionNOSQL insert;
    private final ExpressionNOSQL read;
    MongoCollection<Document> collection;

    public OrchestratorNOSQL(ExpressionNOSQL create, ExpressionNOSQL insert, ExpressionNOSQL read) {
        this.create = create;
        this.insert = insert;
        this.read = read;
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDb = mongoClient.getDatabase("test");
        collection = mongoDb.getCollection("employees");
    }

    public void execute(){
        create.expression(collection);
        insert.expression(collection);
        read.expression(collection);
    }
}

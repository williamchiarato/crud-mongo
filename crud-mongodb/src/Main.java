import com.mongodb.client.*;
import org.bson.Document;
//import com.mongodb.Block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main( String args[] ) {
        //conectar ao banco local
        String uri = "mongodb://superuser:passw0rd@localhost";
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        //lista as databases
        MongoIterable<String> dbs = mongoClient.listDatabaseNames();
        for(String db : dbs) {
            System.out.println("database " + db);
        }

        //usa db se existir ou cria db se nao existir
        MongoDatabase database = mongoClient.getDatabase("Livros");

        //usa collection ou cria se nao existir
        MongoCollection<Document> collection = database.getCollection("lista");

        //cria o documento
        Document doc = new Document("name", "William")
                .append("autor", "roberto")
                .append("count", 2)
                .append("versions", Arrays.asList("v4.4.4", "v4.1", "v3.7"))
                .append("info", new Document("x", 232133).append("y", 3123));

        //criar varios documentos
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 10; i++) {
            documents.add(new Document("i", i));
        }

        //insere o documento
        collection.insertOne(doc);

        //insere varios documentos
        collection.insertMany(documents);

        //conta os documentos existentes
        System.out.println("Total de documentos é: " + collection.countDocuments());

        //encontra o primeiro registro
        Document myDoc = collection.find().first();
        assert myDoc != null;
        System.out.println("O primeiro documento é: " + myDoc.toJson());

        //retorna todos os documentos
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                System.out.println("Documento " + cursor.next().toJson());
            }
        }
        
        //pesquisa documento especifico
       // myDoc = collection.find(eq("i", 71)).first();
        //System.out.println(myDoc.toJson());

        //pesquisa todos os documentos de acordo com o filtro
        //Block<Document> printBlock = new Block<Document>() {
        //	@Override
        //    public void apply(final Document document) {
        //      System.out.println(document.toJson());
        //    }
        //};

        //collection.find(gt("i", 50)).forEach(printBlock);

        //alterar documento
        //collection.updateOne(eq("i", 10), set("i", 110));

        //alterar varios documentos
        //UpdateResult updateResult = collection.updateMany(lt("i", 100), inc("i", 100));
        //System.out.println(updateResult.getModifiedCount());

        //deletar documentos
        //collection.deleteOne(eq("i", 110));

        //deletar todos os documentos
        //DeleteResult deleteResult = collection.deleteMany(gte("i", 100));
        //System.out.println(deleteResult.getDeletedCount());
    }

}

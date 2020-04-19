package com.common.mongodb.service.impl;

import com.common.mongodb.service.MongoService;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Title: MongoDB服务实现
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-04-19
 */
@Component
public class MongoServiceImpl implements MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    @Override
    public Query page(Query query, int start, int limit) {
        return query.skip(start).limit(limit);
    }

    @Override
    public Query buildQuery(Map<String, Object> params) {
        Criteria c = new Criteria();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            c.and(entry.getKey()).is(entry.getValue());
        }
        return new Query(c);
    }

    @Override
    public MongoCollection<Document> getCollection(String collectionName) {
        return mongoTemplate.getCollection(collectionName);
    }

    @Override
    public void insert(String collectionName, Document doc) {
        MongoCollection<Document> collection = getCollection(collectionName);
        collection.insertOne(doc);
    }

    @Override
    public long count(String collectionName, Bson filter) {
        MongoCollection<Document> collection = getCollection(collectionName);
        return collection.countDocuments(filter);
    }

    @Override
    public long distinctCount(String collectionName, Bson filter, String fieldName) {
        MongoCollection<Document> collection = getCollection(collectionName);
        long count = 0;
        Iterator<BsonValue> it = collection.distinct(fieldName, filter, BsonValue.class).iterator();
        while (it.hasNext()) {
            it.next();
            count++;
        }
        return count;
    }

    @Override
    public AggregateIterable<Document> aggregate(String collectionName, List<Bson> pipeline) {
        MongoCollection<Document> collection = getCollection(collectionName);
        return collection.aggregate(pipeline);
    }

    @Override
    public FindIterable<Document> find(String collectionName, Bson filter) {
        MongoCollection<Document> collection = getCollection(collectionName);
        return collection.find(filter);
    }
}

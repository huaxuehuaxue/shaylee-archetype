package com.common.mongodb.service;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Title: MongoDB服务类
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-04-19
 */
public interface MongoService {

    /**
     * 构造分页查询的对象
     *
     * @param query
     * @param start
     * @param limit
     * @return
     */
    Query page(Query query, int start, int limit);

    /**
     * 构造查询对象
     *
     * @param params
     * @return
     */
    Query buildQuery(Map<String, Object> params);

    /**
     * 获取数据
     *
     * @param collectionName 集合名称
     * @return 数据
     */
    MongoCollection<Document> getCollection(String collectionName);

    /**
     * 插入数据
     *
     * @param collectionName 集合名称
     * @param doc 数据
     */
    void insert(String collectionName, Document doc);

    /**
     * 统计集合的数据量
     *
     * @param collectionName 集合名称
     * @param filter 过滤条件
     * @return 数据量
     */
    long count(String collectionName, Bson filter);

    /**
     * 统计指定字段名的不同值数量
     *
     * @param collectionName 集合名称
     * @param filter 查询过滤器
     * @param fieldName 字段名
     * @return 数据量
     */
    long distinctCount(String collectionName, Bson filter, String fieldName);

    /**
     * 根据指定的聚合管道聚合数据
     *
     * @param collectionName 集合名
     * @param pipeline 管道
     * @return 包含聚合操作结果的iterable
     */
    AggregateIterable<Document> aggregate(String collectionName, List<Bson> pipeline);

    /**
     * 查找集合中的所有文档并过滤
     *
     * @param collectionName 集合名
     * @param filter 查询过滤器
     * @return 查询结果的iterable
     */
    FindIterable<Document> find(String collectionName, Bson filter);

}

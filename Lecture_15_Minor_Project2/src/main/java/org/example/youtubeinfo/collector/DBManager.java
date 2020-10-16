package org.example.youtubeinfo.collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.stereotype.Component;

@Component
public class DBManager {

    @Autowired
    private MongoOperations mongoOperations;

    DBManager(){
        initDB();
    }

    public void initDB(){
        mongoOperations.createCollection(Video.class);
        initIndexes();
    }

    public void initIndexes(){
        mongoOperations.indexOps(Video.class).ensureIndex(new Index().on("videoId", Sort.Direction.ASC).unique().background());
    }
}

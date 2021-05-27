package com.hubject.article.mapper;

import com.hubject.my.mapper.MyMapper;
import com.hubject.pojo.Article;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleMapperCustom extends MyMapper<Article> {

    public void updateAppointToPublish();

}
package com.example.duancanhan.service;

import com.example.duancanhan.model.News;

import java.util.List;

public interface INewsService {
    List<News> getAllNews();
    News getNewsById(Long id);
    News createNews(News news);
    News updateNews(Long id, News news);
    void deleteNews(Long id);
}

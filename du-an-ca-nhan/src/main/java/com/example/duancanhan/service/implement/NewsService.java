package com.example.duancanhan.service.implement;

import com.example.duancanhan.model.Image;
import com.example.duancanhan.model.News;
import com.example.duancanhan.repository.NewsRepository;
import com.example.duancanhan.service.INewsService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NewsService implements INewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News getNewsById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    @Override
    public News createNews(News news) {
        // Gắn liên kết ngược giữa image -> news
        if (news.getImages() != null) {
            for (Image img : news.getImages()) {
                img.setNews(news);
            }
        }
        return newsRepository.save(news);
    }

    @Override
    public News updateNews(Long id, News updatedNews) {
        News existingNews = newsRepository.findById(id).orElse(null);
        if (existingNews == null) return null;

        existingNews.setTitle(updatedNews.getTitle());
        existingNews.setContent(updatedNews.getContent());

        // Xoá ảnh cũ (orphanRemoval sẽ tự lo ở @OneToMany)
        existingNews.getImages().clear();

        // Gắn lại ảnh mới
        if (updatedNews.getImages() != null) {
            List<Image> newImages = new ArrayList<>();
            for (Image img : updatedNews.getImages()) {
                img.setNews(existingNews);
                newImages.add(img);
            }
            existingNews.getImages().addAll(newImages);
        }

        return newsRepository.save(existingNews);
    }

    @Override
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}

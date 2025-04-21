package com.example.duancanhan.controller;

import com.example.duancanhan.model.News;
import com.example.duancanhan.service.INewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin("*")
public class NewsController {

    private final INewsService newsService;

    public NewsController(INewsService newsService) {
        this.newsService = newsService;
    }

    // ✅ Lấy danh sách tin
    @GetMapping
    public ResponseEntity<List<News>> getAllNews() {
        List<News> list = newsService.getAllNews();
        return ResponseEntity.ok(list);
    }

    // ✅ Lấy tin theo ID
    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        News news = newsService.getNewsById(id);
        if (news == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(news);
    }

    // ✅ Tạo tin mới
    @PostMapping
    public ResponseEntity<News> createNews(@RequestBody News news) {
        News created = newsService.createNews(news);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // ✅ Cập nhật tin
    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News news) {
        News updated = newsService.updateNews(id, news);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // ✅ Xoá tin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
        return ResponseEntity.noContent().build();
    }
}

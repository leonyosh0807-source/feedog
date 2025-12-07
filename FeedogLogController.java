package com.example.feedog.web;

import com.example.feedog.domain.FeedogLog;
import com.example.feedog.service.FeedogLogService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Feedog の給餌ログに関する REST API を提供するコントローラ。
 */
@RestController
@RequestMapping("/api/logs")
public class FeedogLogController {

    private final FeedogLogService feedogLogService;

    public FeedogLogController(FeedogLogService feedogLogService) {
        this.feedogLogService = feedogLogService;
    }

    /**
     * 給餌ログを 1 件登録するエンドポイント。
     *
     * POST /api/logs
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FeedogLogResponse feed(@RequestBody FeedogLogRequest request) {

        FeedogLog saved = feedogLogService.feed(
                request.getFamilyId(),
                request.getPetId(),
                request.getKind(),
                request.getPortion(),
                request.getMemo()
        );

        return toResponse(saved);
    }

    /**
     * 最近の給餌ログを最大 50 件取得するエンドポイント。
     *
     * GET /api/logs/recent
     */
    @GetMapping("/recent")
    public List<FeedogLogResponse> getRecentLogs() {
        return feedogLogService.getRecentLogs()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    /**
     * ログを 1 件削除するエンドポイント。
     *
     * DELETE /api/logs/{id}
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLog(@PathVariable("id") Long id) {
        feedogLogService.deleteLog(id);
    }

    // ===== エンティティ -> レスポンス DTO 変換 =====

    private FeedogLogResponse toResponse(FeedogLog log) {
        return new FeedogLogResponse(
                log.getId(),
                log.getFamilyId(),
                log.getPetId(),
                log.getFedAt(),
                log.getKind(),
                log.getPortion(),
                log.getMemo(),
                log.getCreatedAt(),
                log.getUpdatedAt()
        );
    }
}
package com.example.feedog.service;

import com.example.feedog.domain.FeedKind;
import com.example.feedog.domain.FeedogLog;
import com.example.feedog.domain.FeedogLogRepository;
import com.example.feedog.domain.Portion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * FeedogLogService の実装クラス。
 * 給餌ログの登録、取得、削除といった基本操作を提供する。
 */
@Service
@Transactional
public class FeedogLogServiceImpl implements FeedogLogService {

    private final FeedogLogRepository repository;

    public FeedogLogServiceImpl(FeedogLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public FeedogLog feed(Long familyId,
                          Long petId,
                          FeedKind kind,
                          Portion portion,
                          String memo) {

        LocalDateTime now = LocalDateTime.now();

        FeedogLog log = new FeedogLog(
                null,           // id（保存時に自動採番）
                familyId,
                petId,
                now,            // fedAt（今）
                kind,
                portion,
                memo,
                now,            // createdAt
                null            // updatedAt（新規登録は null。一覧画面では非表示仕様）
        );

        return repository.save(log);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FeedogLog> getRecentLogs() {
        // ドメイン側の抽象メソッドを呼ぶだけ
        return repository.findRecentLogs();
    }

    @Override
    public void deleteLog(Long logId) {
        repository.deleteById(logId);
    }
}
package com.example.feedog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.feedog.domain.FeedogLog;

/**
 * FeedogLog をデータベースに保存するための JPA ベースのリポジトリ。
 *
 * ドメイン側の FeedogLogRepository を継承しつつ、
 * Spring Data JPA の JpaRepository も継承している。
 */
@Repository
public interface JpaFeedogLogRepository
        extends FeedogLogRepository, JpaRepository<FeedogLog, Long> {

    /** 給餌ログを「新しい fedAt の順」に最大 50 件まで取得する。 */
    List<FeedogLog> findTop50ByOrderByFedAtDesc();

    /** ドメイン側の findRecentLogs() を Spring Data JPA のメソッドへ橋渡し。 */
    @Override
    default List<FeedogLog> findRecentLogs() {
        return findTop50ByOrderByFedAtDesc();
    }
}



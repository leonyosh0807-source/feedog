package com.example.feedog.infrastructure;

import com.example.feedog.domain.FeedogLog;
import com.example.feedog.domain.FeedogLogRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FeedogLog をデータベースに保存するための JPA ベースのリポジトリ。
 *
 * ドメイン側の FeedogLogRepository を継承しつつ、
 * Spring Data JPA の JpaRepository も継承している。
 */
@Repository
public interface JpaFeedogLogRepository
        extends FeedogLogRepository, JpaRepository<FeedogLog, Long> {

    /**
     * 給餌ログを「新しい fedAt の順」に最大 50 件まで取得する。
     * 
     * メソッド名からクエリを自動生成する Spring Data JPA の機能を利用。
     */
    List<FeedogLog> findTop50ByOrderByFedAtDesc();
}
package com.example.feedog.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    // ===== Spring Data JPA が自動実装できるメソッド =====

    /** 給餌ログを「新しい fedAt の順」に最大 50 件まで取得する。 */
    List<FeedogLog> findTop50ByOrderByFedAtDesc();

    /** fedAt が [start, end) の範囲にあるログを取得する（その日分の検索用）。 */
    List<FeedogLog> findByFedAtGreaterThanEqualAndFedAtLessThanOrderByFedAtDesc(
            LocalDateTime start, LocalDateTime end);

    /** 特定の家族があげたログだけを取得（新しい順）。 */
    List<FeedogLog> findByFamilyIdOrderByFedAtDesc(Long familyId);

    /** 特定のペットに対するログだけを取得（新しい順）。 */
    List<FeedogLog> findByPetIdOrderByFedAtDesc(Long petId);

    // ===== ドメイン側のメソッドへ橋渡し（default 実装） =====

    /** ドメイン側の findRecentLogs() を Spring Data JPA のメソッドへ橋渡し。 */
    @Override
    default List<FeedogLog> findRecentLogs() {
        return findTop50ByOrderByFedAtDesc();
    }

    /** ドメイン側の findByFedDate() を fedAt の範囲検索に変換して橋渡し。 */
    @Override
    default List<FeedogLog> findByFedDate(LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.plusDays(1).atStartOfDay();
        return findByFedAtGreaterThanEqualAndFedAtLessThanOrderByFedAtDesc(start, end);
    }

    /** ドメイン側の findByFamilyId() を Spring Data JPA のメソッドへ橋渡し。 */
    @Override
    default List<FeedogLog> findByFamilyId(Long familyId) {
        return findByFamilyIdOrderByFedAtDesc(familyId);
    }

    /** ドメイン側の findByPetId() を Spring Data JPA のメソッドへ橋渡し。 */
    @Override
    default List<FeedogLog> findByPetId(Long petId) {
        return findByPetIdOrderByFedAtDesc(petId);
    }
}




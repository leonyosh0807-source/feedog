package com.example.feedog.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * FeedogLog を永続化層（DBなど）から取得・保存するためのリポジトリ。
 * 実装クラスはインフラ層で用意する想定。
 */
public interface FeedogLogRepository {

    /**
     * ログを保存する。
     * id が null の場合は新規登録、
     * id が存在する場合は更新として扱う想定。
     */
    FeedogLog save(FeedogLog log);

    /** 主キーで 1 件取得する。見つからなければ空。 */
    Optional<FeedogLog> findById(Long id);

    /** 給餌日時の降順（新しい順）で全件取得。 */
    List<FeedogLog> findAllOrderByFedAtDesc();

    /** 指定した日付のログを取得（その日中 0:00〜23:59）。 */
    List<FeedogLog> findByFedDate(LocalDate date);

    /** 特定の家族があげたログだけを取得。 */
    List<FeedogLog> findByFamilyId(Long familyId);

    /** 特定のペットに対するログだけを取得。 */
    List<FeedogLog> findByPetId(Long petId);

    /** 主キーで 1 件削除。 */
    void deleteById(Long id);
}
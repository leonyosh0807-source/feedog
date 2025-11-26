package com.example.feedog.domain;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 犬の給餌ログ 1 件分を表すドメインクラス。
 */
public class FeedogLog {

    private Long id;               // 主キー
    private Long familyId;         // 誰があげたか（Family.id）
    private Long petId;            // どのペットにあげたか（将来複数匹に対応）

    private LocalDateTime fedAt;   // 実際に餌/おやつをあげた日時

    private FeedKind kind;         // 餌 or おやつ
    private Portion portion;       // 多め / 普通 / 少なめ

    private String memo;           // 任意のメモ（null 可）

    private LocalDateTime createdAt;   // レコード作成日時
    private LocalDateTime updatedAt;   // レコード更新日時

    // ==== コンストラクタ ====

    public FeedogLog(Long id,
                     Long familyId,
                     Long petId,
                     LocalDateTime fedAt,
                     FeedKind kind,
                     Portion portion,
                     String memo,
                     LocalDateTime createdAt,
                     LocalDateTime updatedAt) {
        this.id = id;
        this.familyId = familyId;
        this.petId = petId;
        this.fedAt = fedAt;
        this.kind = kind;
        this.portion = portion;
        this.memo = memo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * 新規登録用の簡易コンストラクタ。
     * id / createdAt / updatedAt は保存時に埋める想定。
     */
    public FeedogLog(Long familyId,
                     Long petId,
                     LocalDateTime fedAt,
                     FeedKind kind,
                     Portion portion,
                     String memo) {
        this(null, familyId, petId, fedAt, kind, portion, memo, null, null);
    }

    // ==== getter / setter ====

    public Long getId() {
        return id;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public Long getPetId() {
        return petId;
    }

    public LocalDateTime getFedAt() {
        return fedAt;
    }

    public FeedKind getKind() {
        return kind;
    }

    public Portion getPortion() {
        return portion;
    }

    public String getMemo() {
        return memo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public void setFedAt(LocalDateTime fedAt) {
        this.fedAt = fedAt;
    }

    public void setKind(FeedKind kind) {
        this.kind = kind;
    }

    public void setPortion(Portion portion) {
        this.portion = portion;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // ==== equals / hashCode （idベース） ====

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FeedogLog)) return false;
        FeedogLog that = (FeedogLog) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
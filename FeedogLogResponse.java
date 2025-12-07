package com.example.feedog.web;

import com.example.feedog.domain.FeedKind;
import com.example.feedog.domain.Portion;

import java.time.LocalDateTime;

/**
 * API レスポンスとしてクライアントに返す給餌ログ情報。
 */
public class FeedogLogResponse {

    private Long id;
    private Long familyId;
    private Long petId;
    private LocalDateTime fedAt;
    private FeedKind kind;
    private Portion portion;
    private String memo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public FeedogLogResponse(Long id,
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
}
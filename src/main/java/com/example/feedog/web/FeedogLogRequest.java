package com.example.feedog.web;

import com.example.feedog.domain.FeedKind;
import com.example.feedog.domain.Portion;

/**
 * 給餌ログ登録用のリクエストボディ。
 *
 * POST /api/logs の JSON をこのクラスにマッピングする。
 */
public class FeedogLogRequest {

    private Long familyId;
    private Long petId;
    private FeedKind kind;
    private Portion portion;
    private String memo;

    // Jackson が使うためのデフォルトコンストラクタ
    public FeedogLogRequest() {
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public FeedKind getKind() {
        return kind;
    }

    public void setKind(FeedKind kind) {
        this.kind = kind;
    }

    public Portion getPortion() {
        return portion;
    }

    public void setPortion(Portion portion) {
        this.portion = portion;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}

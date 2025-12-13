package com.example.feedog.domain;

import java.time.LocalDateTime;

/**
 * 給餌する家族（ユーザー）を表すクラス。
 */
public class Family {

    private Long id;
    private String name;            // 表示名（例: "お父さん", "自分の名前"）

    private String displayColor;    // UIで色分けする場合のカラーコード（例: "#FFAA00"）
    private boolean active;         // 有効フラグ（退会などで無効化する用）

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Family(Long id,
                  String name,
                  String displayColor,
                  boolean active,
                  LocalDateTime createdAt,
                  LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.displayColor = displayColor;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * 新規登録用の簡易コンストラクタ。
     * id / createdAt / updatedAt / displayColor は後で設定する想定。
     */
    public Family(String name) {
        this(null, name, null, true, null, null);
    }

    // ==== getter / setter ====

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDisplayColor() {
        return displayColor;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisplayColor(String displayColor) {
        this.displayColor = displayColor;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

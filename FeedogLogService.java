package com.example.feedog.service;

import com.example.feedog.domain.FeedKind;
import com.example.feedog.domain.FeedogLog;
import com.example.feedog.domain.Portion;

import java.util.List;

/**
 * Feedog の給餌に関する基本的な操作だけをまとめたシンプルなサービス。
 */
public interface FeedogLogService {

    /**
     * 給餌ログを1件登録する。
     *
     * 実装側で「いつあげたか（日時）」は原則として「今の時刻」を自動で入れる想定。
     */
    FeedogLog feed(Long familyId,
                   Long petId,
                   FeedKind kind,
                   Portion portion,
                   String memo);

    /**
     * 新しい順で最近の給餌ログを取得する。
     * 何件返すか（例: 50件まで）は実装側で決めてよい。
     */
    List<FeedogLog> getRecentLogs();

    /**
     * ログを1件削除する。
     */
    void deleteLog(Long logId);
}
package com.example.feedog.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.example.feedog.domain.FeedogLog;

public class InMemoryFeedogLogRepository implements FeedogLogRepository {

    private final ConcurrentHashMap<Long, FeedogLog> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public FeedogLog save(FeedogLog log) {
        if (log.getId() == null) {
            long newId = idGenerator.incrementAndGet();
            log.setId(newId);
        }
        store.put(log.getId(), log);
        return log;
    }

    @Override
    public Optional<FeedogLog> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    /**
     * 給餌日時の降順（新しい順）で最大 50 件返す。
     */
    @Override
    public List<FeedogLog> findRecentLogs() {
        List<FeedogLog> list = findAllOrderByFedAtDesc();
        if (list.size() > 50) {
            return list.subList(0, 50);
        }
        return list;
    }

    /**
     * 給餌日時の降順（新しい順）で全件取得。
     */
    @Override
    public List<FeedogLog> findAllOrderByFedAtDesc() {
        List<FeedogLog> list = new ArrayList<>(store.values());
        list.sort(Comparator.comparing(FeedogLog::getFedAt, Comparator.nullsLast(Comparator.reverseOrder())));
        return list;
    }

    /**
     * 指定した日付のログを取得（fedAt の日付で判定）。
     */
    @Override
    public List<FeedogLog> findByFedDate(LocalDate date) {
        List<FeedogLog> result = new ArrayList<>();
        for (FeedogLog log : store.values()) {
            if (log.getFedAt() != null && date.equals(log.getFedAt().toLocalDate())) {
                result.add(log);
            }
        }
        result.sort(Comparator.comparing(FeedogLog::getFedAt, Comparator.nullsLast(Comparator.reverseOrder())));
        return result;
    }

    /**
     * 特定の家族があげたログだけを取得。
     */
    @Override
    public List<FeedogLog> findByFamilyId(Long familyId) {
        List<FeedogLog> result = new ArrayList<>();
        for (FeedogLog log : store.values()) {
            if (familyId != null && familyId.equals(log.getFamilyId())) {
                result.add(log);
            }
        }
        result.sort(Comparator.comparing(FeedogLog::getFedAt, Comparator.nullsLast(Comparator.reverseOrder())));
        return result;
    }

    /**
     * 特定のペットに対するログだけを取得。
     */
    @Override
    public List<FeedogLog> findByPetId(Long petId) {
        List<FeedogLog> result = new ArrayList<>();
        for (FeedogLog log : store.values()) {
            if (petId != null && petId.equals(log.getPetId())) {
                result.add(log);
            }
        }
        result.sort(Comparator.comparing(FeedogLog::getFedAt, Comparator.nullsLast(Comparator.reverseOrder())));
        return result;
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}



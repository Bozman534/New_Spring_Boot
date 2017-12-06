package com.acmecorp.trader.repository;

import com.acmecorp.trader.domain.AuditRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by volen on 2017-08-01.
 */
@Repository
public class InMemoryAuditTrailDAO implements AuditTrailDAO {
    private Logger logger = LoggerFactory.getLogger(InMemoryAuditTrailDAO.class);
    private List<AuditRecord> auditRecords = new ArrayList<>();

    @Override
    public List<AuditRecord> getAllAuditRecords() {
        return Collections.unmodifiableList(auditRecords);
    }

    @Override
    public void saveAuditRecord(AuditRecord record) {
        auditRecords.add(record);
    }

	@Override
	public List<AuditRecord> findAuditRecords(long from, long to) {
		return getAllAuditRecords().stream()
					.filter(rec -> rec.getTimestamp() > from)
					.filter(rec -> rec.getTimestamp() < to)
					.sorted(comparing(AuditRecord::getTimestamp))
					.collect(Collectors.toList());
	}
}

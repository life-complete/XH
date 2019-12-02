package com.sybercare.hospital.health.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sybercare.hospital.health.entity.PrpMaxNo;
import com.sybercare.hospital.health.entity.PrpScompany;
import com.sybercare.hospital.health.entity.PrpSstaff;
import com.sybercare.hospital.health.entity.SaaGrade;

@Repository
public interface PrpsStaffDAO extends PagingAndSortingRepository<PrpSstaff, Long>, JpaSpecificationExecutor<PrpSstaff> {

	@Query("from Tuser a where a.id = (select max(b.id) from Tuser b)")
	List<?> findTuser();

	@Query("from PrpSstaff p where p.userCode = :usercode")
	PrpSstaff readPrpSstaffByUserCode(String usercode);

	@Query("from SaaGrade sg where sg.validStatus = '1' and sg.gradeCode = :title")
	List<SaaGrade> readSasGradeList(String title);

	@Query("from PrpScompany ps where ps.verifyStatus = '1' and ps.hisCode = :department")
	List<PrpScompany> readPrpScompanyList(String department);

	@Query(value = "insert into prpmaxno(groupno, maxno, tablename, flag) values(:groupno, :maxno, :tablename, :flag)", nativeQuery = true)
	void savePrpMaxNo(PrpMaxNo prpMaxNo);

}

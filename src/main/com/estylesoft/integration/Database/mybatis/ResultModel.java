package com.estylesoft.integration.Database.mybatis;

import java.util.ArrayList;
import java.util.List;

public class ResultModel {
	private List<List<Object>> records;
	private Long currentRecordNumber;
		
	public ResultModel() {
		currentRecordNumber = new Long(0);
	}

	public List<List<Object>> getRecords() {
		return records;
	}


	public void setRecords(List<List<Object>> records) {
		this.records = records;
	}


	public Long getCurrentRecordNumber() {
		return currentRecordNumber;
	}

	public void setCurrentRecordNumber(Long currentRecordNumber) {
		this.currentRecordNumber = currentRecordNumber;
	}
}

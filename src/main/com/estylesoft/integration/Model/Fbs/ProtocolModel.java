package com.estylesoft.integration.Model.Fbs;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 09.04.14
 * Time: 17:54
 * To change this template use File | Settings | File Templates.
 */
public class ProtocolModel extends ModelBase {

    private Long packageId;
    private Long markerId;
    private String recordId;
    private String invalidFieldName;
    private String invalidFieldValue;
    private Long extRecordId;
    private Long errorId;

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Long getErrorId() {
        return errorId;
    }

    public void setErrorId(Long errorId) {
        this.errorId = errorId;
    }

    public Long getExtRecordId() {
        return extRecordId;
    }

    public void setExtRecordId(Long extRecordId) {
        this.extRecordId = extRecordId;
    }

    public String getInvalidFieldValue() {
        return invalidFieldValue;
    }

    public void setInvalidFieldValue(String invalidFieldValue) {
        this.invalidFieldValue = invalidFieldValue;
    }

    public String getInvalidFieldName() {
        return invalidFieldName;
    }

    public void setInvalidFieldName(String invalidFieldName) {
        this.invalidFieldName = invalidFieldName;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Long getMarkerId() {
        return markerId;
    }

    public void setMarkerId(Long markerId) {
        this.markerId = markerId;
    }
}

package cn.xry.system.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "dict")
public class Dict implements Serializable{

	private static final long serialVersionUID = 7780820231535870010L;

	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "dict_id")
	private Long dictId;

	@Column(name = "keyy")
	private String keyy;

	@Column(name = "valuee")
	private String valuee;

	@Column(name = "table_name")
	private String tableName;

	@Column(name = "field_name")
	private String fieldName;

	/**
	 * @return DICT_ID
	 */
	public Long getDictId() {
		return dictId;
	}

	/**
	 * @param dictId
	 */
	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	public String getKeyy() {
		return keyy;
	}

	public void setKeyy(String keyy) {
		this.keyy = keyy;
	}

	public String getValuee() {
		return valuee;
	}

	public void setValuee(String valuee) {
		this.valuee = valuee;
	}

	/**
	 * @return FIELD_NAME
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName == null ? null : fieldName.trim();
	}

	/**
	 * @return TABLE_NAME
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName == null ? null : tableName.trim();
	}
}
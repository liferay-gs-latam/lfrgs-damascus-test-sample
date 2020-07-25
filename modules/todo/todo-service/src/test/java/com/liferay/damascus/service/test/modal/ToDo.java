package com.liferay.damascus.service.test.modal;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {

	private String title;

	private String todoRichText;
	private String todoSummaryName;
	private String urlTitle;
	private String todoText;
	private String todoTitleName;
	private Boolean todoBooleanStat;

	@JsonIgnore
	private Long groupId;
	@JsonIgnore
	private Long companyId;
	@JsonIgnore
	private Integer mvccVersion;
	@JsonIgnore
	private Integer status;
	@JsonIgnore
	private Integer statusByUserId;
	@JsonIgnore
	private String statusByUserName;
	@JsonIgnore
	private Instant createDate;
	@JsonIgnore
	private Instant modifiedDate;
	@JsonIgnore
	private Instant statusDate;
	@JsonIgnore
	private Instant todoDateTime;
	@JsonIgnore
	private String todoDocumentLibrary;
	@JsonIgnore
	private Double todoDouble;
	@JsonIgnore
	private Integer todoId;
	@JsonIgnore
	private Integer todoInteger;
	@JsonIgnore
	private Integer userId;
	@JsonIgnore
	private String userName;
	@JsonIgnore
	private String uuid;

}

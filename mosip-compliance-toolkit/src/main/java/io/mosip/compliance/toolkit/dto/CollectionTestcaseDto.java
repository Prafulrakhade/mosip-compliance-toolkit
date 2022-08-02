package io.mosip.compliance.toolkit.dto;

import java.io.Serializable;
import java.util.Map;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.JsonObject;

import io.mosip.compliance.toolkit.config.TestCasesConfig;
import io.mosip.compliance.toolkit.dto.testcases.TestCaseDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CollectionTestcaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3160257810095159707L;

	private String collectionId;

	private String testCaseId;

	private TestCaseDto testcaseJson;

	private String testcaseType;

	private String specVersion;

}

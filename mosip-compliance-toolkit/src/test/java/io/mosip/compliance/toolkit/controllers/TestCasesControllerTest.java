package io.mosip.compliance.toolkit.controllers;

import io.mosip.compliance.toolkit.dto.GenerateSdkRequestResponseDto;
import io.mosip.compliance.toolkit.dto.testcases.*;
import io.mosip.compliance.toolkit.service.TestCasesService;
import io.mosip.compliance.toolkit.util.RequestValidator;
import io.mosip.kernel.core.http.RequestWrapper;
import io.mosip.kernel.core.http.ResponseWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(classes = {TestContext.class, WebApplicationContext.class})
@RunWith(SpringRunner.class)
@WebMvcTest
public class TestCasesControllerTest {

    @InjectMocks
    private TestCasesController testCasesController;

    @Mock
    private TestCasesService testCasesService;

    @Mock
    private RequestValidator requestValidator;

    @Mock
    private Errors errors;

    /*
     * This class tests the initBinder method
     */
    @Test
    public void initBinderTest(){
        WebDataBinder binder = new WebDataBinder(null);
        testCasesController.initBinder(binder);
    }

    /*
     * This class tests the validateRequest method
     */
    @Test
    public void validateRequestTest() throws Exception {
        RequestWrapper<ValidateRequestSchemaDto> input = new RequestWrapper<>();
        testCasesController.validateRequest(input, errors);
    }

    /*
     * This class tests the validateResponse method
     */
    @Test
    public void validateResponseTest() throws Exception {
        RequestWrapper<ValidationInputDto> input = new RequestWrapper<>();
        testCasesController.validateResponse(input, errors);
    }

    /*
     * This class tests the ggenerateRequestForSDKFrmBirs method
     */
    @Test
    public void generateRequestForSDKFrmBirsTest() throws  Exception{
        RequestWrapper<SdkRequestDto> request = new RequestWrapper<>();
        ResponseWrapper<GenerateSdkRequestResponseDto> response = new ResponseWrapper<>();
        Mockito.when(testCasesController.generateRequestForSDKFrmBirs(request,errors)).thenReturn(response);
        Assert.assertEquals(response, testCasesController.generateRequestForSDKFrmBirs(request,errors));
    }

    /*
     * This class tests the getAbisTestCases method
     */
    @Test
    public void getAbisTestCasesTest(){
        String specVersion = "0.9.5";
        ResponseWrapper<List<TestCaseDto>> response = new ResponseWrapper<>();
        Mockito.when(testCasesService.getAbisTestCases(specVersion)).thenReturn(response);
        Assert.assertEquals(response, testCasesController.getAbisTestCases(specVersion));
    }

    @Test
    public void getAbisTestCasesTestExceptoion(){
        ResponseWrapper<List<TestCaseDto>> response = new ResponseWrapper<>();
        ReflectionTestUtils.setField(testCasesController, "service", null);
        testCasesController.getAbisTestCases("0.9.0");
    }


    /*
     * This class tests the getSbiTestCases method
     */
    @Test
    public void getSbiTestCasesTest(){
        String specVersion = "0.9.5";
        String purpose = "Registration";
        String deviceType = "Finger";
        String deviceSubType = "Slap";
        ResponseWrapper<List<TestCaseDto>> response = new ResponseWrapper<>();
        Mockito.when(testCasesService.getSbiTestCases(specVersion, purpose, deviceType, deviceSubType, "no")).thenReturn(response);
        Assert.assertEquals(response, testCasesController.getSbiTestCases(specVersion, purpose, deviceType, deviceSubType, false));
    }

    /*
     * This class tests the getSbiTestCases method in case of Exception
     */
    @Test
    public void getSbiTestCasesExceptionTest(){
        String specVersion = "0.9.5";
        String purpose = "Registration";
        String deviceType = "Finger";
        String deviceSubType = "Slap";
        ResponseWrapper<List<TestCaseDto>> response = new ResponseWrapper<>();
        ReflectionTestUtils.setField(testCasesController, "service", null);
        testCasesController.getSbiTestCases(specVersion, purpose, deviceType, deviceSubType, false);
    }

    /*
     * This class tests the getSdkTestCases method
     */
    @Test
    public void getSdkTestCasesTest(){
        String specVersion = "0.9.1";
        String purpose = "Registration";
        ResponseWrapper<List<TestCaseDto>> response = new ResponseWrapper<>();
        Mockito.when(testCasesService.getSdkTestCases(specVersion, purpose)).thenReturn(response);
        Assert.assertEquals(response, testCasesController.getSdkTestCases(specVersion, purpose));
    }

    /*
     * This class tests the getSdkTestCases method in case of Exception
     */
    @Test
    public void getSdkTestCasesExceptionTest(){
        String specVersion = "0.9.0";
        String purpose = "Matcher";
        ResponseWrapper<List<TestCaseDto>> response = new ResponseWrapper<>();
        ReflectionTestUtils.setField(testCasesController, "service", null);
        testCasesController.getSdkTestCases(specVersion, purpose);
    }

    /*
     * This class tests the generateRequestForSDK method
     */
    @Test
	public void generateRequestForSDKTest() throws Exception {
		List<String> modalities = new ArrayList<>();
		String convertSourceFormat = null;
		String convertTargetFormat = null;
		String bioTestDataName = null;
		ResponseWrapper<GenerateSdkRequestResponseDto> response = new ResponseWrapper<>();

		SdkRequestDto requestDto = new SdkRequestDto();
		requestDto.setMethodName("Segment");
		requestDto.setTestcaseId("SDK2009");
		requestDto.setModalities(modalities);
		requestDto.setBioTestDataName(bioTestDataName);
		requestDto.setConvertSourceFormat(convertSourceFormat);
		requestDto.setConvertSourceFormat(convertTargetFormat);

		RequestWrapper<SdkRequestDto> request = new RequestWrapper<>();
		request.setRequest(requestDto);
		Mockito.when(testCasesService.generateRequestForSDKTestcase(requestDto)).thenReturn(response);
		Assert.assertEquals(response, testCasesController.generateRequestForSDK(request, errors));
	}

    /*
     * This class tests the saveTestCases method
     */
    @Test
    public void saveTestCasesTest() throws Exception {
        RequestWrapper<TestCaseRequestDto> request = new RequestWrapper<>();
        TestCaseRequestDto testCaseRequestDto = new TestCaseRequestDto();
        List<TestCaseDto> testCaseDtoList = new ArrayList<>();
        testCaseRequestDto.setTestCases(testCaseDtoList);
        request.setRequest(testCaseRequestDto);
        ResponseWrapper<TestCaseResponseDto> response = new ResponseWrapper<>();
        Mockito.when(testCasesService.saveTestCases(testCaseDtoList)).thenReturn(response);
        Assert.assertEquals(response, testCasesController.saveTestCases(request));
    }

    /*
     * This class tests the getTestCaseById method
     */
    @Test
    public void getTestCaseByIdTest() throws Exception {
        String testId = "123";
        ResponseWrapper<TestCaseDto> response = new ResponseWrapper<>();
        Mockito.when(testCasesService.getTestCaseById(testId)).thenReturn(response);
        Assert.assertEquals(response, testCasesController.getTestCaseById(testId));
    }
}

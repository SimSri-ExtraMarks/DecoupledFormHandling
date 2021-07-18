package com.formHandling.backend.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.formHandling.backend.helper.FileUploadHelper;

@RunWith(MockitoJUnitRunner.class)
public class FileUploadControllerTest {
	
	@Mock
	FileUploadHelper fileUploadHelper;
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void uploadFileTest() throws Exception{
		assertNotNull(fileUploadHelper);
	}

}

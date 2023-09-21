package com.db.nace;

import com.db.nace.repository.NaceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class NaceApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private NaceRepository repository;

	@Test
	void shouldUploadXls() throws Exception {

		File file = ResourceUtils.getFile("classpath:nace-test.xlsm");
		FileInputStream fis = new FileInputStream(file);
		MockMultipartFile mockMultipartFile = new MockMultipartFile("file",fis);

		mockMvc.perform(MockMvcRequestBuilders.multipart("/nace/upload").file(mockMultipartFile))
				.andExpect(MockMvcResultMatchers.status().isOk());

		Assertions.assertEquals(2,repository.findAll().size());

		String expectedResult = "{\"orderNum\":\"398481\",\"level\":\"1\",\"code\":\"A\",\"parent\":null,\"description\":\"AGRICULTURE, FORESTRY AND FISHING\"}";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/nace/order/398481")).andReturn();

		System.out.println(result.getResponse().getContentAsString());




	}


}

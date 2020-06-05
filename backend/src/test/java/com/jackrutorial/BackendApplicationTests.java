package com.jackrutorial;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackrutorial.models.Job;
import java.util.List;
import com.jackrutorial.models.Job_Location;
import com.jackrutorial.models.Job_Skill;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.util.NestedServletException;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@EnableAutoConfiguration
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class BackendApplicationTests
{

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	public static String asJsonString(final Object obj)
	{
		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@Test
	void testAddJob() throws Exception
	{

		Job job1 = new Job();
		job1.setJobid(8999997);
		job1.setDatemod("12/03/20");
		job1.setCreaterid(1);
		job1.setOpenings(2);
		job1.setIsactive("true");
		job1.setDescription("minimum two years of experience");
		job1.setEmptype("internship");
		job1.setUpdatorid(2);

		this.mockMvc.perform(post("/job/add")
				.content(asJsonString(job1))
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());

		ResultActions resultActions = this.mockMvc.perform(get("/job/print/8999997")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));

		MvcResult result = resultActions.andReturn();
		String contentAsString = result.getResponse().getContentAsString();
		Job jobList = objectMapper.readValue(contentAsString, Job.class);
		assertEquals(jobList.getJobid().intValue(), 8999997);
	}

	@Test
	void testUpdateJob() throws Exception
	{

		Job job1 = new Job();
		job1.setJobid(89999);
		job1.setDatemod("12/03/20");
		job1.setCreaterid(1);
		job1.setOpenings(5);
		job1.setIsactive("true");
		job1.setDescription("minimum two years of experience");
		job1.setEmptype("fte");
		job1.setUpdatorid(2);

		this.mockMvc.perform(put("/job/updates")
				.content(asJsonString(job1))
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());

		ResultActions resultActions = this.mockMvc.perform(get("/job/print/89999")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));


		MvcResult result = resultActions.andReturn();
		String contentAsString = result.getResponse().getContentAsString();
		Job jobList = objectMapper.readValue(contentAsString, Job.class);
		assertEquals(jobList.getOpenings().intValue(), 5);
	}
	@Test
	void testDeleteJob() throws Exception
	{

		this.mockMvc.perform(delete("/job/delete/8999"))
				.andDo(print())
				.andExpect(status().isOk());

		assertThrows(NestedServletException.class,() -> this.mockMvc.perform(get("/job/print/8999"))
					.andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json")));
	}


	@Test
	void testAddJobLoc() throws Exception
	{

		Job_Location job_location=new Job_Location();
		job_location.setLoc("chennai");
		job_location.setJobid(455);

		this.mockMvc.perform(post("/joblocs/add")
				.content(asJsonString(job_location))
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());

		ResultActions resultActions = this.mockMvc.perform(get("/joblocs/lists/455")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));

		MvcResult result = resultActions.andReturn();
		String contentAsString = result.getResponse().getContentAsString();
		List<Job_Location> jobList = objectMapper.readValue(contentAsString,objectMapper.getTypeFactory().constructCollectionType(List.class, Job_Location.class));
		assertEquals(jobList.size(),1);
	}

	@Test
	void testUpdateJobLoc() throws Exception
	{
		Job_Location job_location=new Job_Location();
		job_location.setLoc("banglore");
		job_location.setJobid(455);

		this.mockMvc.perform(put("/joblocs/update")
				.content(asJsonString(job_location))
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());

		ResultActions resultActions = this.mockMvc.perform(get("/joblocs/lists/455")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));
		MvcResult result = resultActions.andReturn();
		String contentAsString = result.getResponse().getContentAsString();
		List<Job_Location> jobList = objectMapper.readValue(contentAsString,objectMapper.getTypeFactory().constructCollectionType(List.class, Job_Location.class));
		assertEquals(jobList.size(),1);

	}

	@Test
	void testDeleteJobLoc() throws Exception
	{

		this.mockMvc.perform(delete("/joblocs/delete/455"))
				.andDo(print())
				.andExpect(status().isOk());

		ResultActions resultActions = this.mockMvc.perform(get("/joblocs/lists/455")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));
		MvcResult result = resultActions.andReturn();
		String contentAsString = result.getResponse().getContentAsString();
		List<Job_Location> jobList = objectMapper.readValue(contentAsString,objectMapper.getTypeFactory().constructCollectionType(List.class, Job_Location.class));
		assertEquals(jobList.size(),0);

	}



	@Test
	void testAddJobSk() throws Exception
	{

		Job_Skill job_skill=new Job_Skill();
		job_skill.setSkill("python");
		job_skill.setJobid(455);

		this.mockMvc.perform(post("/jobsk/add")
				.content(asJsonString(job_skill))
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());

		ResultActions resultActions = this.mockMvc.perform(get("/jobsk/lists/455")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));


		MvcResult result = resultActions.andReturn();
		String contentAsString = result.getResponse().getContentAsString();
		List<Job_Skill> jobList = objectMapper.readValue(contentAsString,objectMapper.getTypeFactory().constructCollectionType(List.class, Job_Skill.class));
		assertEquals(jobList.size(),1);
	}

	@Test
	void testUpdateJobSk() throws Exception {
		Job_Skill job_skill=new Job_Skill();
		job_skill.setSkill("java");
		job_skill.setJobid(455);


		this.mockMvc.perform(put("/jobsk/update")
				.content(asJsonString(job_skill))
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());

		ResultActions resultActions = this.mockMvc.perform(get("/jobsk/lists/455")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));
		MvcResult result = resultActions.andReturn();
		String contentAsString = result.getResponse().getContentAsString();
		List<Job_Skill> jobList = objectMapper.readValue(contentAsString,objectMapper.getTypeFactory().constructCollectionType(List.class, Job_Skill.class));
		assertEquals(jobList.size(),1);

	}
	@Test
	void testDeleteJobSk() throws Exception
	{

		this.mockMvc.perform(delete("/jobsk/delete/455"))

				.andDo(print())
				.andExpect(status().isOk());

		ResultActions resultActions = this.mockMvc.perform(get("/jobsk/lists/455")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));
		MvcResult result = resultActions.andReturn();
		String contentAsString = result.getResponse().getContentAsString();
		List<Job_Skill> jobList = objectMapper.readValue(contentAsString,objectMapper.getTypeFactory().constructCollectionType(List.class, Job_Skill.class));
		assertEquals(jobList.size(),0);

	}

	@Test
	void testListLocations() throws Exception
	{
		this.mockMvc.perform(get("/location/lists")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));
	}

	@Test
	void testListLocationById() throws Exception
	{

		this.mockMvc.perform(get("/location/list/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));
	}

	@Test
	void testListSkills() throws Exception
	{

		this.mockMvc.perform(get("/skill/lists")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));
	}

	@Test
	void testListSkillById() throws Exception
	{

		this.mockMvc.perform(get("/location/list/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));
	}

	@Test
	void testListSkillData() throws Exception
	{

		this.mockMvc.perform(get("/chart/lists")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));
	}

	@Test
	void testListLocationData() throws Exception
	{

		this.mockMvc.perform(get("/chart/listsloc")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));
	}

	@Test
	void testListManagerData() throws Exception
	{

		this.mockMvc.perform(get("/chart/listshm")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.contentType("application/json"));
	}














}




package com.example.learn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class DemoResourceTests {
   @Mock
   private DataDao dataDao;

   @InjectMocks
   DemoResource demoResource;

   @Test
   public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
      Employee employee = new Employee();
      employee.setName("miyav");
      //ResponseEntity responseEntity = new ResponseEntity(employee, HttpStatus.OK);
      Mockito.when(dataDao.findAll()).thenReturn(Arrays.asList(employee));

      ResponseEntity responseEntity = demoResource.getData();
      Assert.assertEquals(responseEntity.getBody(), Arrays.asList(employee));
   }
}
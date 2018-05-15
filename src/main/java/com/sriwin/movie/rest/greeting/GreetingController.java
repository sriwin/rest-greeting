package com.sriwin.movie.rest.greeting;

import com.sriwin.movie.model.GreetingModel;
import com.sriwin.movie.service.greeting.GreetingService;
import com.sriwin.movie.service.greeting.GreetingServiceImpl;
import com.sriwin.movie.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Collection;

@RestController
@RequestMapping(value = RestConstants.REST_API_PATH)
@Api(value = "Greetings Rest Controller", description = "Greetings CRUD Operations")
public class GreetingController {
  private static final Class<GreetingController> applicationClass = GreetingController.class;
  private static final Logger log = LoggerFactory.getLogger(applicationClass);

  @Autowired
  private GreetingService greetingService;

  public GreetingController() {
  }

  @ApiOperation(value = "Returns Hello World message")
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Hello World")
      }
  )
  @RequestMapping(value = "/sayHello/{name}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GreetingModel> sayHello(@PathVariable("name") String name) {
    GreetingModel greetingModel = new GreetingModel();
    greetingModel.setName("Hello " + name);
    greetingModel.setId(BigInteger.valueOf(2999));
    return new ResponseEntity<GreetingModel>(greetingModel, HttpStatus.OK);
  }

  @ApiOperation(value = "Returns Hello World")
  @ApiResponses(
      value = {
          @ApiResponse(code = 204, message = "No content found"),
          @ApiResponse(code = 200, message = "Greeting message in different languages")
      }
  )
  @RequestMapping(value = RestConstants.GET_ALL_GREETINGS_URL,
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Collection<GreetingModel>> getAllGreetings() {
    Collection<GreetingModel> greetingsCollection = greetingService.getAllGreetings();
    if (greetingsCollection == null) {
      return new ResponseEntity<Collection<GreetingModel>>(greetingsCollection,
          HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<Collection<GreetingModel>>(greetingsCollection,
        HttpStatus.OK);
  }

  @RequestMapping(value = RestConstants.GET_GREETING_URL,
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GreetingModel> getGreeting(@PathVariable("id") BigInteger id) {
    GreetingModel greetingModel = greetingService.getGreeting(id);
    return new ResponseEntity<GreetingModel>(greetingModel, HttpStatus.OK);
  }

  @RequestMapping(value = RestConstants.CREATE_GREETING_URL,
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GreetingModel> createGreeting(@RequestBody GreetingModel greetingModel) {
    GreetingModel updatedGreetingModel = greetingService.addGreeting(greetingModel);
    return new ResponseEntity<GreetingModel>(updatedGreetingModel, HttpStatus.CREATED);
  }

  @RequestMapping(value = RestConstants.UPDATE_GREETING_URL,
      method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GreetingModel> updateGreeting(@RequestBody GreetingModel greetingModel) {
    if (greetingModel == null) {
      return new ResponseEntity<GreetingModel>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    GreetingModel updatedGreetingModel = greetingService.addGreeting(greetingModel);
    return new ResponseEntity<GreetingModel>(updatedGreetingModel, HttpStatus.OK);
  }

  @RequestMapping(value = RestConstants.DELETE_GREETING_URL,
      method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GreetingModel> deleteGreeting(@PathVariable("id") BigInteger id) {
    boolean deleteFlag = greetingService.deleteGreeting(id);
    if (!deleteFlag) {
      return new ResponseEntity<GreetingModel>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<GreetingModel>(HttpStatus.NO_CONTENT);
  }
}
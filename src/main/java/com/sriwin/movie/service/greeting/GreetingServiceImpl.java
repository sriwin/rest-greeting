package com.sriwin.movie.service.greeting;

import com.sriwin.movie.exception.ResourceNotFoundException;
import com.sriwin.movie.model.GreetingModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingServiceImpl implements GreetingService {
  private static final Class<GreetingServiceImpl> applicationClass = GreetingServiceImpl.class;
  private static final Logger log = LoggerFactory.getLogger(applicationClass);

  private static BigInteger nextId;
  private static Map<BigInteger, GreetingModel> greetingsMap;

  public GreetingServiceImpl() {
  }

  static {
    nextId = BigInteger.ZERO;
    GreetingModel greetingModel1 = new GreetingModel();
    greetingModel1.setName("HOLA – Spanish");
    save(greetingModel1);

    GreetingModel greetingModel2 = new GreetingModel();
    greetingModel2.setName("CIAO – Italian");
    save(greetingModel2);

    GreetingModel greetingModel3 = new GreetingModel();
    greetingModel3.setName("Namskaram");
    save(greetingModel3);
  }

  @Override
  public Collection<GreetingModel> getAllGreetings() {
    return greetingsMap.values();
  }

  @Override
  public GreetingModel getGreeting(BigInteger id) {
    GreetingModel greetingModel = greetingsMap.get(id);
    if (greetingModel == null) {
      throw new ResourceNotFoundException("Greeting with id (" + id + ") not found in the database");
    }
    return greetingsMap.get(id);
  }

  @Override
  public GreetingModel addGreeting(GreetingModel greetingModel) {
    return save(greetingModel);
  }

  @Override
  public GreetingModel updateGreeting(GreetingModel greetingModel) {
    return save(greetingModel);
  }

  @Override
  public boolean deleteGreeting(BigInteger id) {
    if (!greetingsMap.containsKey(id)) {
      return false;
    }
    greetingsMap.remove(id);
    return true;
  }

  private static GreetingModel save(GreetingModel greetingModel) {
    if (greetingsMap == null) {
      greetingsMap = new HashMap<BigInteger, GreetingModel>();
    }

    if (greetingsMap.containsKey(greetingModel.getId())) {
      greetingsMap.put(greetingModel.getId(), greetingModel);
      return greetingModel;
    }

    nextId = nextId.add(BigInteger.ONE);
    greetingModel.setId(nextId);
    greetingsMap.put(nextId, greetingModel);
    return greetingModel;
  }
}
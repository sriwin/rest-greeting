package com.sriwin.movie.service.greeting;

import com.sriwin.movie.model.GreetingModel;

import java.math.BigInteger;
import java.util.Collection;

public interface GreetingService {
  Collection<GreetingModel> getAllGreetings();

  public GreetingModel getGreeting(BigInteger id);

  public GreetingModel addGreeting(GreetingModel greetingModel);

  public GreetingModel updateGreeting(GreetingModel greetingModel);

  public boolean deleteGreeting(BigInteger id);
}

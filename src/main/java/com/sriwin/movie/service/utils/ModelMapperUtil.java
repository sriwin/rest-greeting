package com.sriwin.movie.service.utils;

import com.sriwin.movie.service.greeting.GreetingServiceImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMapperUtil {
  private static final Class<ModelMapperUtil> applicationClass = ModelMapperUtil.class;
  private static final Logger log = LoggerFactory.getLogger(applicationClass);
  @Autowired
  private ModelMapper modelMapper;

  public <D, S> List<D> mapAll(final Collection<S> inputList, Class<D> outputClass) {
    return inputList.stream()
        .map(entry -> map(entry, outputClass))
        .collect(Collectors.toList());
  }

  public <D, S> D map(final S inputClass, Class<D> outputClass) {
    return modelMapper.map(inputClass, outputClass);
  }

  public <S, D> D map(final S source, D destination) {
    modelMapper.map(source, destination);
    return destination;
  }
}
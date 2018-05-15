package com.sriwin.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MovieApplication {
  private static final Class<MovieApplication> applicationClass = MovieApplication.class;
  private static final Logger log = LoggerFactory.getLogger(applicationClass);
  public static void main(String[] args) {
    SpringApplication.run(MovieApplication.class, args);
  }
}
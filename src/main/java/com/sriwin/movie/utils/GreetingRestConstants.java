package com.sriwin.movie.utils;

public interface GreetingRestConstants {
  String GET_ALL_GREETINGS_URL = "/greetings";

  String UPDATE_GREETING_URL = "/greeting/{id}";
  String CREATE_GREETING_URL = "/greeting";
  String GET_GREETING_URL = "/greeting/{id}";
  String DELETE_GREETING_URL = "/greeting/{id}";
  String ERROR_MSG_URL = "/greeting/errorMsg/{id}";

  String SAY_HELLO_URL = "/sayHello/{name}";
}
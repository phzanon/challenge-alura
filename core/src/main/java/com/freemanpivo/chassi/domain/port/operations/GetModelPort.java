package com.freemanpivo.chassi.domain.port;

import java.util.List;

public interface GetModelPort<T> {
  T getDetails(Long id);
  List<T> getAll();
}

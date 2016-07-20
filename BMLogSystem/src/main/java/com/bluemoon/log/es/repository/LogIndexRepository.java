package com.bluemoon.log.es.repository;

import com.bluemoon.log.domain.LogVo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by LeonWong on 16/7/20.
 */
public interface LogIndexRepository extends CrudRepository<LogVo, Long> {

}

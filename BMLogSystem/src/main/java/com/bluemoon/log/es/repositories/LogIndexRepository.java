package com.bluemoon.log.es.repositories;

import com.bluemoon.log.domain.LogVo;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * Created by LeonWong on 16/7/20.
 */
public interface LogIndexRepository extends ElasticsearchCrudRepository<LogVo, Long> {

}

package com.bluemoon.log.es.service;

import com.bluemoon.log.domain.LogVo;
import com.bluemoon.log.es.repositories.LogIndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LeonWong on 16/7/20.
 */
@Service
public class EsService {

    @Autowired
    LogIndexRepository logIndexRepository;

    /**
     * 测试插入记录
     *
     * @param logVo
     */
    public void doInsert(LogVo logVo) {
        logIndexRepository.save(logVo);
    }
}

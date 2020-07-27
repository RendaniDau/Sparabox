package com.sparabox.business;

import com.sparabox.domain.business.AuthorizationRequestDto;

/**
 * Created by rendani.dau on 2020/04/24.
 */
public interface AuthorizationRequestProcessor {
    void processTransaction(AuthorizationRequestDto authorizationRequestDto);
}

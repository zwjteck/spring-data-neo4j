/*
 * Copyright (c)  [2011-2016] "Pivotal Software, Inc." / "Neo Technology" / "Graph Aware Ltd."
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with
 * separate copyright notices and license terms. Your use of the source
 * code for these subcomponents is subject to the terms and
 * conditions of the subcomponent's license, as noted in the LICENSE file.
 *
 */

package org.springframework.data.neo4j.transactions.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.transactions.domain.User;
import org.springframework.data.neo4j.transactions.repo.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author vince
 */
@Component
public class ServiceB {

    @Autowired
    private UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void update() throws Exception {
        getBilbo();
        throw new Exception();
    }

    public User getBilbo() {
        Collection<User> userList = userRepository.findUserByName("Bilbo Baggins");
        if (userList.iterator().hasNext()) {
            return userList.iterator().next();
        }
        return null;
    }
}

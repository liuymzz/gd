package com.lym.gd.service;

import com.lym.gd.entity.Resource;
import com.lym.gd.entity.User;
import com.lym.gd.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyaming
 * @date 2018/3/12 下午9:48
 */
@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Resource> findResourcesByUser(User user) {
        return resourceRepository.findResourcesByResourceRole(user.getUserRole());
    }
}

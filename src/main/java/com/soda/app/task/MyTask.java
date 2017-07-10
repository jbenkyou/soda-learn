package com.soda.app.task;

import com.soda.app.model.User;
import com.soda.app.service.UserService;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.generator.model.elements.DefaultCacheConfigurationElement;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MyTask {

    @Resource
    private UserService userService;

    private boolean flag1 = true, flag2 = true;

    public void test() {
        CacheManager cacheManager = CacheManager.getInstance();
        // cacheManager.ad
    }

    @Scheduled(fixedDelay = 1000 * 5)
    public void task1() {
        if (flag1) {
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
            }
            flag1 = false;
        }
        List<User> users = userService.listUser();
        if (users == null) {
            System.out.println("NULL");
            return;
        }
        users.forEach(user -> System.out.println("ADD: " + user.toString()));
    }

    // @Scheduled(fixedDelay = 1000 * 15)
    public void task2() {
        if (flag2) {
            try {
                Thread.sleep(1000 * 20);
            } catch (InterruptedException e) {
            }
            flag2 = false;
        }
        List<User> users = userService.evictUser();
        if (users == null) {
            System.out.println("NULL");
            return;
        }
        users.forEach(user -> System.out.println("EVICT: " + user.toString()));
    }

}

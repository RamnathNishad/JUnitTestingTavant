package com.example.demo.employee.demo2;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate restTemplate;
    private final String USER_API_URL = "https://jsonplaceholder.typicode.com/users";

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUserById(Long id) {
        return restTemplate.getForObject(USER_API_URL + "/" + id, User.class);
    }

    public User[] getAllUsers() {
        return restTemplate.getForObject(USER_API_URL, User[].class);
    }

    public User createUser(User user) {
        return restTemplate.postForObject(USER_API_URL, user, User.class);
    }

    public void deleteUser(Long id) {
        restTemplate.delete(USER_API_URL + "/" + id);
    }

    public void updateUser(Long id, User user) {
        restTemplate.put(USER_API_URL + "/" + id, user);
    }
}

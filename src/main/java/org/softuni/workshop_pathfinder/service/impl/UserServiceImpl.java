package org.softuni.workshop_pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.workshop_pathfinder.model.entity.User;
import org.softuni.workshop_pathfinder.model.entity.enums.LevelEnum;
import org.softuni.workshop_pathfinder.model.service.UserServiceModel;
import org.softuni.workshop_pathfinder.repository.UserRepository;
import org.softuni.workshop_pathfinder.service.UserService;
import org.softuni.workshop_pathfinder.util.CurrentUser;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setLevel(LevelEnum.BEGINNER);

        userRepository.save(user);

    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setUsername(username).setId(id);

    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);

    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id).map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public boolean isNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public User findCurrentLoggedUser() {
        return userRepository.findById(currentUser.getId()).orElse(null);
    }
}

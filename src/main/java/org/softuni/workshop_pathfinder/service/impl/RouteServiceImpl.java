package org.softuni.workshop_pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.workshop_pathfinder.model.entity.Route;
import org.softuni.workshop_pathfinder.model.service.RouteServiceModel;
import org.softuni.workshop_pathfinder.model.view.RouteDetailsViewModel;
import org.softuni.workshop_pathfinder.model.view.RouteViewModel;
import org.softuni.workshop_pathfinder.repository.RouteRepository;
import org.softuni.workshop_pathfinder.service.CategoryService;
import org.softuni.workshop_pathfinder.service.RouteService;
import org.softuni.workshop_pathfinder.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public List<RouteViewModel> findAllRoutesView() {
        return routeRepository
                .findAll()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel = modelMapper.map(route, RouteViewModel.class);
                    routeViewModel.setPictureUrl(route.getPictures().isEmpty()
                            ? "/images/pic4.jpg"
                            : route.getPictures().stream().findFirst().get().getUrl());
                    return routeViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {

        Route route = modelMapper.map(routeServiceModel, Route.class);
        route.setAuthor(userService.findCurrentLoggedUser());
        route.setCategories(routeServiceModel
                .getCategories()
                .stream()
                .map(categoryService::findCategoryByName)
                .collect(Collectors.toSet()));


        routeRepository.save(route);
    }

    @Override
    public RouteDetailsViewModel findById(Long id) {
        return routeRepository.findById(id)
                .map(route -> modelMapper.map(route,RouteDetailsViewModel.class)).orElse(null);
    }
}

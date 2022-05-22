package org.softuni.workshop_pathfinder.service;

import org.softuni.workshop_pathfinder.model.service.RouteServiceModel;
import org.softuni.workshop_pathfinder.model.view.RouteDetailsViewModel;
import org.softuni.workshop_pathfinder.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();

    void addNewRoute(RouteServiceModel routeServiceModel);

    RouteDetailsViewModel findById(Long id);
}

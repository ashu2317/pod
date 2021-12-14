package com.talpods.routesortingservice.service;

import com.talpods.routesortingservice.model.BoardingPassModel;
import com.talpods.routesortingservice.model.TalPodBoardingPassRequest;
import com.talpods.routesortingservice.util.TalPodConverter;
import com.talpods.routesortingservice.util.TalPodRouteUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class RouteSortingService {
    private TalPodConverter talPodConverter;
    private TalPodRouteUtil talPodRouteUtil;

    public List<String> sortTheRoutes(List<TalPodBoardingPassRequest> talPodBoardingPassRequests) {

      //Create Map with Key as FROM
      Map<String, BoardingPassModel> boardingPassModels = talPodConverter.talPodBoardingPassRequestList2BoardingPassModelMapConverter.apply(talPodBoardingPassRequests);

      // Find Starting point to produce list of routes
      String startingPoint = talPodRouteUtil.findTheRouteNode(boardingPassModels);

      List<String> results =  new ArrayList<>();

        return talPodRouteUtil.prepareRouteResponse(boardingPassModels, startingPoint, results);
    }
}

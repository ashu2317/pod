package com.talpods.routesortingservice.util;

import com.talpods.routesortingservice.model.BoardingPassModel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TalPodRouteUtil {

    private static int depthCount = 0;

    public String findTheRouteNode(Map<String, BoardingPassModel> boardingPassMap) {

        Map<String, Integer> routes = new HashMap<>();
        int maxDepth = 0;
        String rootNode = "";

        for (Map.Entry<String, BoardingPassModel> entry : boardingPassMap.entrySet()) {
            depthCount = 0;
            int depth = findDepth(boardingPassMap, entry.getKey());

            if(depth >  maxDepth) {
                maxDepth = depth;
                rootNode = entry.getKey();
            }
        }
        return rootNode;
    }

    private int findDepth(Map<String, BoardingPassModel> boardingPassMap, String key) {

        if(boardingPassMap.get(key) == null) return depthCount;

        else {
            depthCount++;
            findDepth(boardingPassMap, boardingPassMap.get(key).getTo());
        }

        return depthCount;

    }

    public List<String> prepareRouteResponse(Map<String, BoardingPassModel> stringBoardingPassModelMap, String source, List<String> resultList) {
        if(stringBoardingPassModelMap.get(source) == null) return resultList;
        BoardingPassModel boardingPassModel = stringBoardingPassModelMap.get(source);
        String output = null;
        switch (boardingPassModel.getTransportType()) {
            case "TRAIN" :
                 output = "Take train from %s to %s. %s";
                resultList.add(String.format(output, boardingPassModel.getFrom(), boardingPassModel.getTo(), boardingPassModel.getSeat() == null? "No seat assignment.": "Sit in seat "+boardingPassModel.getSeat()));
                break;
            case "BUS" :
                 output = "Take Bus from %s to %s. %s";
                resultList.add(String.format(output, boardingPassModel.getFrom(), boardingPassModel.getTo(), boardingPassModel.getSeat() == null? "No seat assignment.": "Sit in seat "+boardingPassModel.getSeat()));
                break;
            case "AIRPLANE" :
                 output = "Take flight from %s to %s. %s";
                resultList.add(String.format(output, boardingPassModel.getFrom(), boardingPassModel.getTo(), boardingPassModel.getSeat() == null? "No seat assignment.": "Sit in seat "+boardingPassModel.getSeat()));
                break;
            default:
                output = "Take transport from %s to %s. %s";
                resultList.add(String.format(output, boardingPassModel.getFrom(), boardingPassModel.getTo(), boardingPassModel.getSeat() == null? "No seat assignment.": "Sit in seat "+boardingPassModel.getSeat()));
        }

       return prepareRouteResponse(stringBoardingPassModelMap, stringBoardingPassModelMap.get(source).getTo(), resultList);
    }
}

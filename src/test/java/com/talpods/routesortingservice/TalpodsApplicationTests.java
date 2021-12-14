package com.talpods.routesortingservice;

import com.talpods.routesortingservice.model.BoardingPassModel;
import com.talpods.routesortingservice.util.TalPodRouteUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class TalpodsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void find_start_point_of_journey_in_the_map() {
        Map<String, BoardingPassModel> fromToMap = new HashMap<>();
       // fromToMap.put("A", "B");
        fromToMap.put("A", new BoardingPassModel("A","B",null,"BUS",null));
        fromToMap.put("B", new BoardingPassModel("B","C",null,"BUS",null));
        fromToMap.put("C", new BoardingPassModel("C","D",null,"BUS",null));
        fromToMap.put("D", new BoardingPassModel("D","E",null,"BUS",null));
        fromToMap.put("E", new BoardingPassModel("E","F",null,"BUS",null));
        fromToMap.put("F", new BoardingPassModel("F","G",null,"BUS",null));



        TalPodRouteUtil talPodRouteUtil = new TalPodRouteUtil();

        assertThat("A").isEqualTo(talPodRouteUtil.findTheRouteNode(fromToMap));

    }

    @Test

    void find_the_output_list() {
        Map<String, BoardingPassModel> fromToMap = new HashMap<>();
        TalPodRouteUtil talPodRouteUtil = new TalPodRouteUtil();
        // fromToMap.put("A", "B");
        fromToMap.put("A", new BoardingPassModel("A","B",null,"BUS",null));
        fromToMap.put("B", new BoardingPassModel("B","C",null,"TRAIN",null));
        fromToMap.put("C", new BoardingPassModel("C","D",null,"TRAIN",null));
        fromToMap.put("D", new BoardingPassModel("D","E",null,"AIRPLANE",null));
        fromToMap.put("E", new BoardingPassModel("E","F",null,"AIRPLANE",null));
        fromToMap.put("F", new BoardingPassModel("F","G",null,"BUS",null));
        String startingPoint = talPodRouteUtil.findTheRouteNode(fromToMap);
        List<String> results = new ArrayList<>();

        talPodRouteUtil.prepareRouteResponse(fromToMap, startingPoint, results);

        results.forEach(s ->{
            System.out.println(s);
        });
    }

}

package com.talpods.routesortingservice.util;

import com.talpods.routesortingservice.model.BoardingPassModel;
import com.talpods.routesortingservice.model.TalPodBoardingPassRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class TalPodConverter {

    public Function<TalPodBoardingPassRequest, BoardingPassModel> talPodBoardingPassRequest2BoardingPassModelConverter =  talPodBoardingPassRequest -> {
        BoardingPassModel boardingPassModel = new BoardingPassModel();
        BeanUtils.copyProperties(talPodBoardingPassRequest, boardingPassModel);
    return boardingPassModel;
    };

    public Function<List<TalPodBoardingPassRequest>, List<BoardingPassModel>> talPodBoardingPassRequestList2BoardingPassModelListConverter = talPodBoardingPassRequests -> {
        List<BoardingPassModel> boardingPassModels = new ArrayList<>();
        talPodBoardingPassRequests.forEach(talPodBoardingPassRequest -> {
            boardingPassModels.add( talPodBoardingPassRequest2BoardingPassModelConverter.apply(talPodBoardingPassRequest));
        });
        return boardingPassModels;
    };

    public Function<List<TalPodBoardingPassRequest>, Map<String, BoardingPassModel>> talPodBoardingPassRequestList2BoardingPassModelMapConverter = talPodBoardingPassRequests -> {
        Map<String, BoardingPassModel> BoardingPassModelMap = new HashMap<>();

        talPodBoardingPassRequests.forEach(talPodBoardingPassRequest -> {
            BoardingPassModel boardingPassModel =  talPodBoardingPassRequest2BoardingPassModelConverter.apply(talPodBoardingPassRequest);
            BoardingPassModelMap.put(boardingPassModel.getFrom(), boardingPassModel);
        });

        return BoardingPassModelMap;
    };

}

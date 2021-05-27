package com.hubject.user.controller;

import com.hubject.api.BaseController;
import com.hubject.api.controller.user.MyFansControllerApi;
import com.hubject.enums.Sex;
import com.hubject.grace.result.GraceJSONResult;
import com.hubject.pojo.vo.FansCountsVO;
import com.hubject.user.service.MyFanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFansController extends BaseController implements MyFansControllerApi {

    final static Logger logger = LoggerFactory.getLogger(MyFansController.class);

    @Autowired
    private MyFanService myFanService;

    @Override
    public GraceJSONResult isMeFollowThisWriter(String writerId,
                                                String fanId) {
        boolean res = myFanService.isMeFollowThisWriter(writerId, fanId);
        return GraceJSONResult.ok(res);
    }

    @Override
    public GraceJSONResult follow(String writerId, String fanId) {
        myFanService.follow(writerId, fanId);
        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult unfollow(String writerId, String fanId) {
        myFanService.unfollow(writerId, fanId);
        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult queryAll(String writerId,
                                    Integer page,
                                    Integer pageSize) {

        if (page == null) {
            page = COMMON_START_PAGE;
        }
        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }

        return GraceJSONResult.ok(myFanService.queryMyFansList(writerId,
                                    page,
                                    pageSize));
    }

    @Override
    public GraceJSONResult queryRatio(String writerId) {

        int manCounts = myFanService.queryFansCounts(writerId, Sex.man);
        int womanCounts = myFanService.queryFansCounts(writerId, Sex.woman);

        FansCountsVO fansCountsVO = new FansCountsVO();
        fansCountsVO.setManCounts(manCounts);
        fansCountsVO.setWomanCounts(womanCounts);

        return GraceJSONResult.ok(fansCountsVO);
    }

    @Override
    public GraceJSONResult queryRatioByRegion(String writerId) {
        return GraceJSONResult.ok(myFanService
                .queryRegionRatioCounts(writerId));
    }
}

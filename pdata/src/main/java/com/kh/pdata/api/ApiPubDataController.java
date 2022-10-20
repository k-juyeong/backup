package com.kh.pdata.api;


import com.kh.pdata.svc.ApiExplorer;
import com.kh.pdata.svc.FaciReq;
import com.kh.pdata.svc.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/pub")
@RequiredArgsConstructor
public class ApiPubDataController {

    private final ApiExplorer apiExplorer;

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getJsonData(@RequestParam("faciNm") String faciNm) {

        FaciReq faciReq = new FaciReq();

        faciReq.setNumOfRows("10");       //	표시건수	4	0	10	표시건수
        faciReq.setPageNo("1");           //	페이지번호	4	0	1	페이지번호
        faciReq.setFaciNm(faciNm);         //	체육시설명	200	0	365당구클럽	체육시설명
//        faciReq.setFcobNm("");            //	업종명	3	0	당구장업	업종명
//        faciReq.setFtypeNm("");           //	시설유형명	5	0	당구장	시설유형명
//        faciReq.setFaciRoadAddr1("");     //	도로명주소	20	0	강원도 … 로 xx	도로명주소
//        faciReq.setFaciAddr1("");         //	지번주소	20	0	강원도 .. 리 xx	지번주소

        Response res = apiExplorer.apiCall(faciReq);
        log.info("res={}",res);
        return res;
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public Response getXMLData() {
        Response res = apiExplorer.apiCall();
        log.info("res={}",res);
        return res;
    }


}

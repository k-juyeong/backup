package com.kh.pdata.svc;

import lombok.Data;

@Data
public class FaciReq {
    private String numOfRows;        //	표시건수	4	0	10	표시건수
    private String pageNo;           //	페이지번호	4	0	1	페이지번호
    private String faciNm;           //	체육시설명	200	0	365당구클럽	체육시설명
//    private String fcobNm;           //	업종명	3	0	당구장업	업종명
//    private String ftypeNm;          //	시설유형명	5	0	당구장	시설유형명
//    private String faciRoadAddr1;    //	도로명주소	20	0	강원도 … 로 xx	도로명주소
//    private String faciAddr1;        //	지번주소	20	0	강원도 .. 리 xx	지번주소
}

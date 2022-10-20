package com.kh.exam1;
// 실습과제 8.3: Concert.java
// 콘서트 티켓을 모델한다

import java.util.Scanner;

public class Concert {
    // 가수의 이름
    private String singerName;

    // 공연 장소의 수용 인원
    private int capacity;

    // 팔린 티켓 수
    private int ticketsSold = 0;
    // 변수들
    // 인터넷 티켓 가격, 현장 티켓 가격, 총 판매 금액과 인터넷 판매 가능 여부
    private int costInternet = 0;
    private int costAtSite = 0;
    private int totalSales = 0;
    private boolean webSalesOnly = true;


    // 생성자 메소드
    // 가수의 이름, 공연 장소의 수용 인원, 인터넷 티켓 가격과 현장 티켓 가격을
    // 각각 주어진 값으로 초기화하면서 객체를 생성한다
    public Concert(String name, int max, int costOverWeb, int costAtVenue) {
        this.singerName = name;
        this.capacity = max;
        this.costInternet = costOverWeb;
        this.costAtSite = costAtVenue;
    }

    // 티켓을 판다
    public void doTicketSaleInternet() {
        // 남은 티켓들의 수를 알려 준다
        System.out.print("남은 티켓들 수는? (최대 " + getTicketsLeft() + ") ");

        // 구매 요청한 티켓 수를 입력 받는다
        System.out.print("원하는 티켓의 수를 입력하세요 : ");
        Scanner reader = new Scanner(System.in);
        int toSell = reader.nextInt();

        // 티켓을 판다
        boolean saleCompleted = sellTickets(toSell);

        // 판매가 완료되면 티켓들의 총 가격을 출력하고
        // 티켓을 판매할 수 없으면 오류 메시지를 출력한다
        if (saleCompleted == true) {
            getSaleCostInternet(toSell);
            System.out.println("구매 완료하였습니다!");
            System.out.println("총 구매 가격 : " + (toSell * costInternet));
        } else {
            System.out.println("판매 가능 티켓 수를 초과하였습니다.");
        }
    }

    public void doTicketSaleInSite() {
        // 남은 티켓들의 수를 알려 준다
        System.out.print("남은 티켓들 수는? (최대 " + getTicketsLeft() + ") ");

        // 구매 요청한 티켓 수를 입력 받는다
        Scanner reader = new Scanner(System.in);
        int toSell = reader.nextInt();

        // 티켓을 판다
        boolean saleCompleted = sellTickets(toSell);

        // 판매가 완료되면 티켓들의 총 가격을 출력하고
        // 티켓을 판매할 수 없으면 오류 메시지를 출력한다
        if (saleCompleted == true) {
            getSaleCostAtSite(toSell);
            System.out.println();
            System.out.println("구매 완료하였습니다!");
            System.out.println("총 구매 가격 : " + (toSell * costAtSite));
        } else {
            System.out.println("판매 가능 티켓 수를 초과하였습니다.");

        }
    }

    // 구매 요청한 수만큼 티켓을 판다
    // 티켓을 판매할 수 있으면 판매 기록을 갱신하고 true를 반환한다
    // 티켓을 판매할 수 없으면 false를 반환한다
    public boolean sellTickets(int number) {
        if (number <= (capacity - ticketsSold)) {
            this.ticketsSold += number;
            return true;
        } else {
            return false;
        }
    }

    // 구매 요청한 티켓들의 가격을 계산한 후 반환한다
    public int getSaleCostInternet(int number) {
        totalSales += number * costInternet;
        return totalSales;
        // 여기에 코드를 삽입하세요
    }

    public int getSaleCostAtSite(int number) {
        this.totalSales += number * costAtSite;
        return totalSales;
        // 여기에 코드를 삽입하세요
    }

    // 인터넷 판매를 종료한다
    public void webSalesOver() {
        this.webSalesOnly = false;
    }

    // 팔린 티켓들의 수를 알려 준다
    public int getTicketsSold() {
        return ticketsSold;
    }


    // 남은 티켓들의 수를 알려 준다
    public int getTicketsLeft() {
        return this.capacity - this.ticketsSold;
    }

    // 총 판매 금액을 알려 준다
    public int getTotalSales() {
        return totalSales;
    }

    // 인터넷 판매 가능 여부를 알려 준다
    public boolean webSalesOnly() {
        if ((capacity - ticketsSold) >= 1) {
//            System.out.println();
//            System.out.println("인터넷으로 구매 가능합니다.");
            return true;
        } else {
//            System.out.println();
//            System.out.println("인터넷으로 구매 불가능합니다.");
            return false;
        }
    }

    // 팔린 티켓 수와 총 판매 금액을 반환한다
    public String getSalesReport() {
        String str = "";
        str += "팔린 티켓 수 : " + this.getTicketsSold() + "\n";
        str += "총 판매 금액 : " + this.getTotalSales() +"\n";
        return str;
    }
}
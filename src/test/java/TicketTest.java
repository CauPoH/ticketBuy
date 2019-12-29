import Pages.BaseFunc;
import Pages.MainPage;
import Pages.TicketPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTest {

    @Test
    public void ticketTest() throws InterruptedException {

        //open browser and maximazi window
        BaseFunc baseFunc = new BaseFunc();
        //go to url
        baseFunc.goToUrl("http://www.qaguru.lv:8089/tickets/");
        // select departure
        MainPage mainPage = new MainPage(baseFunc);
        String departure = mainPage.selectDeparture("RIX");
        // select destination
        String arrival = mainPage.selectArrival("SVO");
        // click go go go
        mainPage.clickGoButton();
        // work on Ticket page
        TicketPage ticketPage = new TicketPage(baseFunc);
        //Check if selected departure are the same as on Ticket page
        String departureToCompare = ticketPage.depToCompare();
        Assertions.assertEquals(departure, departureToCompare, "Departure not matching!");
        String arrivalToCompare = ticketPage.arrToCompare();
        Assertions.assertEquals(arrival,arrivalToCompare, "Arrival not matching!");
        // fill in fields
        ticketPage.fillName("John");
        ticketPage.fillSurname("Landon");
        ticketPage.fillDiscount("dkmw1dk");
        ticketPage.fillAdults("1");
        ticketPage.fillChildren("1");
        ticketPage.fillLuggage("2");
        //ticket.selectNextDate("11-05-2018");
        ticketPage.selectByText("11");
        // click get price
        ticketPage.clickGetTicket();
        // click book
        ticketPage.clickBook2Button();
        // select seat
        Integer seat = 12;
        baseFunc.await();
        ticketPage.selectSeat(seat);
        // check if message after choosing seat compare
        String seatToCompare = ticketPage.seatToComp();
        System.out.println(seatToCompare.endsWith(String.valueOf(seat)));
        // click book
        ticketPage.clickBook3Button();
        // check thank you page
        Assertions.assertEquals(ticketPage.thanksMessageText(),"Thank You for flying with us!","Text not matching!");
        // close browser
        baseFunc.closeBrowser();

    }
}

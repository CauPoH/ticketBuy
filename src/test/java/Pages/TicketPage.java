package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TicketPage {

    private BaseFunc baseFunc;

    private final By NAME = By.id("name");
    private final By SURNAME = By.id("surname");
    private final By DISCCODE = By.id("discount");
    private final By ADULTSCOUNT = By.id("adults");
    private final By CHILDRENCOUNT = By.id("children");
    private final By LUGGAGECOUNT = By.id("bugs");
    private final By NEXTFLIGHT = By.id("flight");
    private final By GETTICKETBUTTON = By.xpath(".//*[@id=\"fullForm\"]/span[8]");
    private final By BOOK2BUTTON = By.id("book2");
    private final By BOOK3BUTTON = By.id("book3");
    private final By SEATCSN = By.xpath(".//div[contains(@class, 'seat')]");
    private final By THXTEXT = By.xpath(".//div[contains(@class, 'finalTxt')]");
    private final By CHOOSENDEST = By.xpath(".//span[contains(@class, 'bTxt')]");
    private final By CHOOSENSEAT = By.xpath(".//div[contains(@class, 'line')]");


    public TicketPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillName(String name) {
        baseFunc.fieldFill(NAME, name);
    }

    public void fillSurname(String surname) {
        baseFunc.fieldFill(SURNAME, surname);
    }

    public void fillDiscount(String discount) {
        baseFunc.fieldFill(DISCCODE, discount);
    }

    public void fillAdults(String adults) {
        baseFunc.fieldFill(ADULTSCOUNT, adults);
    }

    public void fillChildren(String children) {
        baseFunc.fieldFill(CHILDRENCOUNT, children);
    }

    public void fillLuggage(String luggage) {
        baseFunc.fieldFill(LUGGAGECOUNT, luggage);
    }

    public void selectByText(String value) {
        baseFunc.selectByValue(NEXTFLIGHT, value);
    }

    public void clickGetTicket() {
        baseFunc.getElement(GETTICKETBUTTON).click();
    }

    public void clickBook2Button() {
        baseFunc.getElement(BOOK2BUTTON).click();
    }

    public void selectSeat(int seatNumber) {
        List<WebElement> seats = baseFunc.listOfElements(SEATCSN);
        baseFunc.await();
        for (int i = 0; i < seats.size(); i++) {
            if (Integer.parseInt(seats.get(i).getText()) == seatNumber) {
                seats.get(i).click();
                break;
            }
        }
    }

    public void clickBook3Button() {
        baseFunc.getElement(BOOK3BUTTON).click();
    }

    public String thanksMessageText() {
        String tocompare = baseFunc.getElement(THXTEXT).getText();
        return tocompare;
    }

    public String depToCompare() {
        String ticketDeparture = baseFunc.getElements(CHOOSENDEST).get(0).getText();
        return ticketDeparture;
    }

    public String arrToCompare() {
        String ticketArrival = baseFunc.getElements(CHOOSENDEST).get(1).getText();
        return ticketArrival;
    }

    public String seatToComp() {
        String seatChoosen = baseFunc.getElement(CHOOSENSEAT).getText();
        return seatChoosen;
    }
}

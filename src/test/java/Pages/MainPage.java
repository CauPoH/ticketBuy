package Pages;

import org.openqa.selenium.By;

public class MainPage {

    private BaseFunc baseFunc;

    private final By MPLEFTDROP = By.id("afrom");
    private final By MPRIGHTDROP = By.id("bfrom");
    private final By GOGOGOBTN = By.xpath(".//span[contains(@class, 'gogogo')]");

    public MainPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String selectDeparture(String airport) {
        //Find dropdown
        baseFunc.selectByText(MPLEFTDROP, airport);
        // select airport srazu srabotal vishe
        return airport;
    }

    public String selectArrival(String airport) {
        //Find dropdown
        baseFunc.selectByText(MPRIGHTDROP, airport);
        // select airport srazu srabotal vishe
        return airport;
    }

    public void clickGoButton() {
        //Select button
        baseFunc.getElement(GOGOGOBTN).click();
    }
}

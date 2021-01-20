package pop.mainView;

import org.openqa.selenium.By;
import pop.mainView.useCaseView.UseCaseView;
import util.Base;

public class DashboardView extends Base {

    private By selectCardByDataTestId(String cardId) {
        return By.xpath(String.format("//div[@data-testid='%s']", cardId));
    }


    private void selectCard(String cardName) {

        click(selectCardByDataTestId(cardName));

    }

    public UseCaseView selectUseCases() {

        selectCard("use_cases_card_id");

        return new UseCaseView();
    }


}

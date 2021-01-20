package pop.mainView.useCaseView;

import org.openqa.selenium.By;
import util.Base;

public class CreateUseCaseView extends Base {



    private By inputTemplateByName(String arg) {
        return By.xpath(String.format("//input[@name='%s']", arg));
    }

    private By buttonTemplateByDataTestId(String arg) {
        return By.xpath(String.format("//button[@data-testid='%s']", arg));
    }

    private By TEXTAREA_DESCRIPTION = By.xpath("//textarea[@name='description']");


    public CreateUseCaseView setTitle(String title) {

        writeText(inputTemplateByName("title"), title);

        return this;
    }

    public int getNumberOfCharactersFromTitle() {
        return getNumberOfCharactersFromInput(inputTemplateByName("title"));
    }

    public int getNumberOfCharactersFromDescription() {
        return getNumberOfCharactersFromInput(TEXTAREA_DESCRIPTION);
    }

    public int getNumberOfCharactersFromExpectedResult() {
        return getNumberOfCharactersFromInput(inputTemplateByName("expected_result"));
    }

    public int getNumberOfCharactersFromStep(int stepNumber) {
        return getNumberOfCharactersFromInput(inputTemplateByName("testStepId-" + Integer.toString(stepNumber - 1)));
    }


    private int getNumberOfCharactersFromInput(By inputLocator) {

        String a = getElementText(inputLocator);
        int character = a.length();
        return character;

    }


    public CreateUseCaseView setDescription(String description) {
        writeText(TEXTAREA_DESCRIPTION, description);
        return this;
    }

    public CreateUseCaseView setExpectedResult(String expectedResult) {
        writeText(inputTemplateByName("expected_result"), expectedResult);
        return this;
    }

    public CreateUseCaseView setTextInUseCase(int useCaseNumber, String text) {
        writeText(inputTemplateByName("testStepId-" + Integer.toString(useCaseNumber - 1)), text);
        return this;
    }

    public CreateUseCaseView addStep() {
        click(buttonTemplateByDataTestId("add_step_btn"));
        return this;
    }

    public UseCaseView submit() {
        click(buttonTemplateByDataTestId("submit_btn"));
        waitForNotVisible(buttonTemplateByDataTestId("submit_btn"));
        return new UseCaseView();
    }


}

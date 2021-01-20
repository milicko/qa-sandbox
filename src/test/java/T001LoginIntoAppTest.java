import api.AccessToken;
import api.UseCaseList;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import pop.Login;
import pop.mainView.DashboardView;
import pop.mainView.useCaseView.CreateUseCaseView;
import pop.mainView.useCaseView.UseCaseView;
import util.DriverCreation;

public class T001LoginIntoAppTest extends DriverCreation {


    @Before
    public void deleteAllUseCases() {

        UseCaseList.deleteAllUseCases();


    }

    @Test
    public void loginIntoSandbox() {


        openUrl("https://qa-sandbox.apps.htec.rs/login");

        Login login = new Login();

        DashboardView dashboardView = login.setUserName("decoderkg@gmail.com").setPassword("dtodorovickg").submit();

        UseCaseView useCaseView = dashboardView.selectUseCases();


        for (int i = 0; i < 4; i++) {

            CreateUseCaseView createUseCaseView = useCaseView.createUseCase();
            String title = createRandomString();
            createUseCaseView.setTitle(title).setDescription(createRandomString())
                    .setExpectedResult(createRandomString()).setTextInUseCase(1, createRandomString()).addStep()
                    .setTextInUseCase(2, createRandomString()).addStep()
                    .setTextInUseCase(3, createRandomString()).submit();

            useCaseView.openUseCase(title);

            createUseCaseView.setTitle("This field previously had: " + createUseCaseView.getNumberOfCharactersFromTitle())
                    .setDescription("This field previously had: " + createUseCaseView.getNumberOfCharactersFromDescription())
                    .setExpectedResult("This field previously had: " + createUseCaseView.getNumberOfCharactersFromExpectedResult())
                    .setTextInUseCase(1, "This field previously had: " + createUseCaseView.getNumberOfCharactersFromStep(1))
                    .setTextInUseCase(2, "This field previoysly had: " + createUseCaseView.getNumberOfCharactersFromStep(2))
                    .setTextInUseCase(3, "This field previously had: " + createUseCaseView.getNumberOfCharactersFromStep(3)).submit();


        }


    }

}

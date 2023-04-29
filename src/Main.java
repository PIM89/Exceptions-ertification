import Model.SaveUserDataModel;
import Model.UserDataModel;
import Presenter.Presenter;
import View.View;

/*

 */
public class Main {
    public static void main(String[] args) {
        Presenter presenter = new Presenter(new View(), new UserDataModel(), new SaveUserDataModel());
        presenter.buttonClick();
    }
}
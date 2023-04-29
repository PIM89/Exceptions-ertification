package Presenter;

import Model.*;
import View.*;

import java.time.LocalDate;

public class Presenter {
    View view;
    UserDataModel userDataModel;
    SaveUserDataModel saveUserDataModel;

    public Presenter(View view, UserDataModel userDataModel, SaveUserDataModel saveUserDataModel){
        this.view = view;
        this.userDataModel = userDataModel;
        this.saveUserDataModel = saveUserDataModel;
    }

    public void buttonClick(){
        view.showMenu();
        int choose = view.setChoose();
        switch (choose) {
            case 1:
                userDataModel.setLastName(view.setLastName());
                userDataModel.setFirstName(view.setFirstName());
                userDataModel.setMiddleName(view.setMiddleName());
                userDataModel.setDateOfBirth(view.setDateOfBirth());
                userDataModel.setPhoneNumber(view.setPhoneNumber());
                userDataModel.setGender(view.setGender());
                saveUserDataModel.saveData(userDataModel);
                buttonClick();
                break;
            case 2:
                String[] data = view.inputUserData();
                userDataModel.setLastName(data[0].substring(0, 1).toUpperCase() + data[0].substring(1));
                userDataModel.setFirstName(data[1].substring(0, 1).toUpperCase() + data[1].substring(1));
                userDataModel.setMiddleName(data[2].substring(0, 1).toUpperCase() + data[2].substring(1));
                userDataModel.setDateOfBirth(LocalDate.parse(data[3]));
                userDataModel.setPhoneNumber(Long.parseLong(data[4]));
                userDataModel.setGender(data[5]);
                saveUserDataModel.saveData(userDataModel);
                buttonClick();
                break;
        }
    }
}

package Model;

import java.io.FileWriter;
import java.io.IOException;


/*
Операция сохранения информации в файл
 */
public class SaveUserDataModel {
    UserDataModel userDataModel;

    public void saveData(UserDataModel userDataModel) {
        String fileName = userDataModel.getLastName() + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            String text = userDataModel.getLastName() + " " + userDataModel.getFirstName() +
                    " " + userDataModel.getMiddleName() + " " + userDataModel.getDateOfBirth() +
                    " " + userDataModel.getPhoneNumber() + " " + userDataModel.getGender() + "\n";
            writer.write(text);
            System.out.println("Операция сохранения прошла успешно!");
        } catch (IOException e) {
            System.out.println("Возникла ошибка при сохранении информации в файл!");
        }
    }
}

package View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class View {
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("Для добавления данных о пользователе пошагово выберите -> 1");
        System.out.println("Для добавления данных о пользователе одной строкой выберите -> 2");
        System.out.println("Для окончания работы программы выберите -> любое другое значение");
    }

    public int setChoose() {
        System.out.println("Выбор операции: ");
        return scanner.nextInt();
    }

    public String setFirstName() {
        System.out.println("Введите имя: ");
        String firstName = scanner.next();
        return firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
    }

    public String setMiddleName() {
        System.out.println("Введите отчество: ");
        String middleName = scanner.next();
        return middleName.substring(0, 1).toUpperCase() + middleName.substring(1);
    }

    public String setLastName() {
        System.out.println("Введите фамилию: ");
        String lastName = scanner.next();
        return lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
    }

    public LocalDate setDateOfBirth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату рождения (ДД.ММ.ГГГГ): ");
        String date = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateOfBirth = null;
        try {
            dateOfBirth = LocalDate.parse(date, formatter);
            return dateOfBirth;
        } catch (Exception e) {
            System.out.println("Введены некоректные данные или не соответствует формат ввода данных!\n" + "Попробуйте еще раз!");
            return setDateOfBirth();
        }
    }


    public long setPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер телефона (целое беззнаковое число без форматирования): ");
        String number = scanner.next();
        long phoneNumber = 0;
        try {
            phoneNumber = Long.parseLong(number);
            return phoneNumber;
        } catch (NumberFormatException e) {
            System.out.println("Введены не корректные данные! Попробуйте еще раз!");
            return setPhoneNumber();
        }
    }

    public String setGender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пол (м или ж): ");
        String gender = (scanner.next()).toLowerCase();
        if (gender.equals("м")) {
            gender = "f";
        } else if (gender.equals("ж")) {
            gender = "m";
        } else {
            System.out.println("Введены не корректные данные! Попробуйте еще раз!");
            return setGender();
        }
        return gender;
    }

    /*
    Ввод и обработка данных введенных пользователем в одну строку
     */
    public String[] inputUserData() {
        System.out.println("Введите данные через пробел " + "(1. Фамилия " + "2. Имя " + "3. Отчество " + "4. Дата рождения(ДД.ММ.ГГГГ) " + "5. Номер телефона 6. Пол(м или ж):");
        scanner.nextLine();
        String data = scanner.nextLine();
        String result[] = data.split(" ");
        if (result.length < 6) {
            System.out.println("Данные введены не корректно! Недостаточно информации. Попробуйте еще раз!\n");
            return inputUserData();
        } else if (result.length > 6) {
            System.out.println("Данные введены не корректно! Представлена информация больше необходимой. Попробуйте еще раз!\n");
            return inputUserData();
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(result[3], formatter);
            result[3] = String.valueOf(date);
        } catch (Exception e) {
            System.out.println("Введены некоректные данные о дате рождения! Попробуйте еще раз!");
            result[3] = String.valueOf(setDateOfBirth());
        }

        try {
            long phoneNumber = Long.parseLong(result[4]);
            result[4] = String.valueOf(phoneNumber);
        } catch (NumberFormatException e) {
            System.out.println("Введены не корректные о номере телефона! Попробуйте еще раз!");
            result[4] = String.valueOf(setPhoneNumber());
        }

        if (result[5].equals("м")) {
            result[5] = "f";
        } else if (result[5].equals("ж")) {
            result[5] = "m";
        } else {
            System.out.println("Введены не корректные данные! Попробуйте еще раз!");
            result[5] = setGender();
        }
        return result;
    }
}

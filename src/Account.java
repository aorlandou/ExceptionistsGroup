import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Collections;
import java.util.InputMismatchException;

public class Account {
	private String name, surname, password, birthdate, gender, municipality;
	private String phone;
	private String covidState; // returns "yes" if user has covid or "no" if he doesn't have
	private String message;
	List<String> notifications = new ArrayList<String>();
	List<String> friends = new ArrayList<String>();

	public Account(String name, String surname, String password, String phone, String birthdate, String gender,
			String municipality) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.phone = phone;
		this.birthdate = birthdate;
		this.gender = gender;
		this.municipality = municipality;
	}

	public void userState(String key1) {
		if (covidState != null) {
			if (key1.equals("yes")) {
				covidState = "positive";
			} else if (covidState.equals("positive") && key1.equals("no")) {
				covidState = "recovered";
			} else if (covidState.equals("negative") && key1.equals("no")) {
				covidState = "negative";
			}
		} else {
			if (key1.equals("no")) {

				covidState = "negative";
			} else {
				covidState = "positive";
			}
		}
		DB data = new DB();
		data.updateState(phone, covidState);
		try {
			sendNotification();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * This method adds a new notification in every friend's notification list when
	 * the user is tested positive or negative for the virus
	 */
	public void sendNotification() {
		List<String> temp;
		DB data = new DB();
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		if (covidState.equals("positive")) {
			message = date.format(formatter) + " " + DateTimeFormatter.ofPattern("hh:mm a").format(LocalTime.now())
					+ "Your friend " + surname + " " + name + " has been tested possitive for COVID-19";
		} else if (covidState.equals("negative")) {
			message = date.format(formatter) + " " + DateTimeFormatter.ofPattern("hh:mm a").format(LocalTime.now())
					+ "Your friend " + surname + " " + name + " has been tested negative for COVID-19 ";
		} else if (covidState.equals("recovered")) {
			message = date.format(formatter) + " " + DateTimeFormatter.ofPattern("hh:mm a").format(LocalTime.now())
					+ "Your friend " + surname + " " + name + " has recovered from COVID-19 ";
		}
		if (friends.size() != 0) {
			for (int i = 0; i < friends.size(); i++) {
				data = new DB();
				data.addNotification(friends.get(i), message);

			}
			if (covidState.equals("positive")) {

				for (int i = 0; i < friends.size(); i++) {
					message = date.format(formatter) + " "
							+ DateTimeFormatter.ofPattern("hh:mm a").format(LocalTime.now()) + "One person from "
							+ data.getSurname(friends.get(i)) + " " + data.getName(friends.get(i))
							+ " friend list has been tested possitive for COVID-19 ";
					temp = data.getFriends(friends.get(i));
					if (temp.size() != 0) {
						for (int j = 0; j < temp.size(); j++) {
							data.addNotification(temp.get(j), message);
						}
					}
				}
			}

		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCovidState() {
		return covidState;
	}

	public void setCovidState(String covidState) {
		this.covidState = covidState;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<String> notifications) {
		this.notifications = notifications;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
}

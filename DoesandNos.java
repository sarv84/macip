package com.test.nlp;

public class DoesandNos {

	/**
	 * 2nd Lesson Nlp JOSE D Silva
	 */

	public void means(int choice) {
		// int stuffChoices = 8;
		String choiceString;
		switch (choice) {
		case 1:
			choiceString = "Eat";
			break;
		case 2:
			choiceString = "Sleep";
			break;
		case 3:
			choiceString = "Drink";
			break;
		case 4:
			choiceString = "DoWhatWhen";
			break;
		case 5:
			choiceString = "DoWhyHow";
			break;

		default:
			choiceString = "Sleep";
			break;
		}
		System.out.println("NLP CLASSIC 2nd lesson" + choiceString);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoesandNos ds = new DoesandNos();
		ds.means(8);

	}

}

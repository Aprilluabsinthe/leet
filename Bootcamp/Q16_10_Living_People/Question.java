package Q16_10_Living_People;

import java.util.Random;

public class Question {

    public static int maxAliveYear(Person[] people, int min, int max) {
        int[] peopleAlive = getAliveArray(people,min,max);
        int maxAliveYear = getMaxAliveYear(peopleAlive);
        return maxAliveYear + min;

    }

    private static int getMaxAliveYear(int[] peopleAlive) {
        int sum = 0;
        int max = 0;
        int maxYear = 0;
        for(int i = 0 ; i < peopleAlive.length; i++){
            int aliveNumber = peopleAlive[i];
            sum += aliveNumber;
            if(sum > max){
                max = sum;
                maxYear = i;
            }
        }
        return maxYear;
    }

    private static int[] getAliveArray(Person[] people, int min, int max) {
        int[] peopleAlive = new int[max-min+2];
        for(Person person : people){
            int birth = person.birth - min;
            peopleAlive[birth]++;
            int death = person.death - min;
            peopleAlive[death+1]--;
        }
        return peopleAlive;
    }


    public static void main(String[] args) {
		int n = 3;
		int first = 1900;
		int last = 2000;
		Random random = new Random();
		Person[] people = new Person[n];
		for (int i = 0; i < n; i++) {
			int birth = first + random.nextInt(last - first);
			int death = birth + random.nextInt(last - birth);
			people[i] = new Person(birth, death);
			System.out.println(birth + ", " + death);
		}
		int year = maxAliveYear(people, first, last);
		System.out.println(year);
	}
    
}

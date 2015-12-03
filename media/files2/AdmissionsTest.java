/*
 * You have been hired to automate the admissions of a university.
 * Students apply for admission. A person who applies for admission is called an applicant.
 * Applicants provide their name, reservation category, 10th % and Math score.
 * Create an Applicant class with the attributes given above.
 * Add all applicants to an array and make sure any number of applicants are accepted.
 
 * University has 20 seats and the seats are alloted based on the following rules.
   * 1. All the students are rank orderd based on the 10th %.
   * 2. If there is a tie, Math score is used to break the tie.
   * 3. If there is a tie again, lexiographic order of the name is used to break the tie.
   * 4. Names will be unique and so there is no chance of a further tie in raking.
   * 5. 50% of 20 (10) of the seats are in the order of merit. All reserved categories compete for these seats.
   * 6. 26% of 20 (5) of the seats are reserved for OBC.
   * 7. 15% of 20 (3) of the seats are reserved for SC.
   * 8. 8% of 20  (2) of the seats are reserved for ST.
   * 9. If there are not enough reserved categories then fill up the seats with the next best applicant from the merit list
 * 
 * The following skeleton code is provided so that it is easy for us to auto grade your solution.
 * Ask your mentors if you have any questions about the skeleton code.
 */

import java.util.Scanner;
import java.util.StringTokenizer;

class Applicant {
  public Applicant(String name, String reservedCategory, String xthScore, String mathScore) {}

  public String toString() {
    String s = "";
    s += getName() + ",";
    s += getCategory() + ",";
    s += getXScore() + ",";
    s += getMathScore();
    return s;
  }

  public String getName() {return null;}
  public String getCategory() {return null;}
  public int getXScore() {return 0;}
  public int getMathScore() {return 0;}
}

class Admissions {
  public Admissions() {}
  public void addApplicant(Applicant a) {}
  public Applicant[] getOCList() {return null;}
  public Applicant[] getOBCList() {return null;}
  public Applicant[] getSCList() {return null;}
  public Applicant[] getSTList() {return null;}
}

public class AdmissionsTest {
  public static void main(String args[]) throws Exception {
    /* 
     * reading a file which has student details and
     * create applicant objects and add them to the Admissions 
     */
    Admissions a = new Admissions();

    Scanner s = new Scanner(System.in);
    while(s.hasNextLine()) {
      String line = s.nextLine();
      StringTokenizer tokens = new StringTokenizer(line, ",");
      a.addApplicant(new Applicant(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken()));
      // token 1 = name, token 2 = reservation category, tokens 3 = 10th %, tokens 4 = Math score
      // Important note: All the arguments are passed to the Applicant constructor as strings.
      // tokens 3 and tokens 4 should be converted to ints inside the Applicant constructor
      
    }

    /*
     * get the list of students who are given admission under OC - 50%
     * Expected list of OC students:
        * Shyla,OBC,91,82
        * Mandara,OBC,90,96
        * Valmiki,OBC,90,88
        * Vasuki,OC,86,50
        * Charan,OC,79,22
        * Matrika,ST,78,66
        * Valin,OC,77,99
        * Purdy,OC,77,82
        * Raji,OC,77,78
        * Agni,SC,76,83
     */
    Applicant[] ocList = a.getOCList();
    System.out.println("OC List:");
    for(Applicant applicant:ocList) {
      System.out.println("\t" + applicant);
    }

    /*
     * get the list of students who are given admission under OBC - 27%
     * Expected list of OBC students:
        * Lajila,OBC,68,36
        * Anya,OBC,63,73
        * Kali,OBC,60,80
        * Kanishka,OBC,60,48
        * Jay,OBC,56,49
     */
    Applicant[] obcList = a.getOBCList();
    System.out.println("OBC List:");
    for(Applicant applicant:ocList) {
      System.out.println("\t" + applicant);
    }

    /*
     * get the list of students who are given admission under SC - 15%
     * Expected list of SC students:
       * Chandaka,SC,60,69
       * Rishi,SC,31,17
       * Shraddha,OC,75,77 (Picked the best OC as there are not enough SC candidates to fill up)
     */
    Applicant[] scList = a.getSCList();
    System.out.println("SC List:");
    for(Applicant applicant:ocList) {
      System.out.println("\t" + applicant);
    }

    /*
     * get the list of students who are given admission under ST - 8%
     * Expected list of ST students:
       * Nipa,ST,62,100
       * Eshana,ST,19,16
     */
    Applicant[] stList = a.getSTList();
    System.out.println("ST List:");
    for(Applicant applicant:ocList) {
      System.out.println("\t" + applicant);
    }
  }
}
// YOUR NAME: Valentine Diaz   
// COLLABORATORS: 
// DATE: 10/01/2024
          
public class Main
{
     static String ASCII_ART_0 = "    .----.    .----.  ",
                ASCII_ART_1 = "   (  --  \\  /  --  )",
                ASCII_ART_2 = "          |  |        ",
                ASCII_ART_3 = "         _/  \\_      ",
                ASCII_ART_4 = "        (_    _)      ",
                ASCII_ART_5 = "     ,    `--`    ,   ",
                ASCII_ART_6 = "     \\'-.______.-'/  ",
                ASCII_ART_7 = "      \\          /   ",
                ASCII_ART_8 = "       '.--..--.'     ",
                ASCII_ART_9 = "         `\"\"\"\"\"` ",
                ASCII_CREDIT = "   ascii art by: jgs    ";

        static String TITLE_USA = "UNITED STATES OF AMERICA",
                TITLE_EAC = "EMPLOYMENT AUTHORIZATION CARD";
        static String LABEL_SURNAME = "Surname", LABEL_GIVEN_NAME = "Given Name", LABEL_USCIS_NUM = "USCIS#",
                LABEL_CATEGORY = "Category", LABEL_CARD_NUM = "Card#", LABEL_BIRTH_COUNTRY = "Country of Birth",
                LABEL_TERMS_CONDITIONS = "Terms and Conditions", LABEL_BIRTH_DATE = "Date of Birth",
                LABEL_SEX = "Sex", LABEL_VALID_DATE = "Valid From:", LABEL_EXPIRE_DATE = "Card Expires:",
                LABEL_REENTRY_DISCLAIMER = "NOT VALID FOR REENTRY TO U.S."; 
    public static void main(String[] args)
    {
        //ascii art credit: http://www.oocities.org/spunk1111/bodypart.htm
        
        //DECLARATION SECTION
        //complete fields
        String surname, givenName, category, cardNum, birthCountry, termsAndConditions;
        char sex;

        //parts of fields
        String birthMonth;
        int uscisNum1, uscisNum2, uscisNum3, birthDay, birthYear,
                validDay, validMonth, validYear, expireMonth, expireDay, expireYear;

        //extra vars to help with formatting of Strings (not raw data like above vars)
        String uscisNum, dateOfBirth, validDate, expireDate;

        //INITIALIZATION SECTION
        //surname = "CHAPETON-LAMAS";
        surname = UtilityBelt.readString("Enter surname:\n", 1,20);

        //givenName = "NERY";
        givenName = UtilityBelt.readString("Enter given name:\n", 1,15);

        /*uscisNum1 = 12;
        uscisNum2 = 4;
        uscisNum3 = 789;
        */
        uscisNum1 = UtilityBelt.readInt("Enter uscis number: (3 digits at a time)\n", 0,999);
        uscisNum2 = UtilityBelt.readInt("", 0,999);
        uscisNum3 = UtilityBelt.readInt("", 0,999);

        //category = "C09";
        category = UtilityBelt.readString("Enter category:\n", 3,3);

        //cardNum = "SRC9876543210";
        cardNum = UtilityBelt.readString("Enter card number:\n", 13,13);

        //birthCountry = "Guatemala";
        birthCountry = UtilityBelt.readString("Where were you born?:\n", 1,30);

        //termsAndConditions = "None";
        termsAndConditions = UtilityBelt.readString("Any terms and conditions? (Put None):\n", 4, 5);

        /* 
        birthDay = 1;
        birthMonth = "JAN";
        birthYear = 1970;
        */
        birthDay = UtilityBelt.readInt("What day where you born?\n",1,31);
        birthMonth = UtilityBelt.readString("What month were you born? (Ex: January = JAN, Februrary = FEB)\n",
                3,3 );
        birthYear = UtilityBelt.readInt("What year were you born?\n",1000,9999);


        //sex = 'M'; //note single quotes
        sex = UtilityBelt.readChar("Male (M), or Female(F)?:\n", "MF");
        
        //validMonth = 2;
       // validDay = 2;
        //validYear = 2020;
        validMonth = UtilityBelt.readInt("When is this card valid until? (Month)\n", 1, 12);
        validDay = UtilityBelt.readInt("(Day)", 1, 31);
        validYear = UtilityBelt.readInt("(Year)", 1000, 9999); 
        
        
        //expireMonth = 2;
        //expireDay = 2;
        //expireYear = 2022;
        expireMonth = UtilityBelt.readInt("When does this card expire? (Month)\n", 1, 12);
        expireDay = UtilityBelt.readInt("(Day)", 1, 31);
        expireYear = UtilityBelt.readInt("(Year)", 1000, 9999);

        //Strings to help clean up long printf's below
        uscisNum = String.format("%03d-%03d-%03d", uscisNum1, uscisNum2, uscisNum3);
        dateOfBirth = String.format("%02d %s %d", birthDay, birthMonth, birthYear);
        //validDate = String.format("%02d/%02d/%4d", validMonth, validDay, validYear);
        //expireDate = String.format("%02d/%02d/%4d", expireMonth, expireDay, expireYear);


        validDate = Main.formatDate(validMonth, validDay, validYear);
        expireDate = Main.formatDate(expireMonth, expireDay, expireYear);


        String finishedCard = Main.formatCard(surname,givenName,category,cardNum,birthCountry,
                termsAndConditions,sex,uscisNum,dateOfBirth,validDate,expireDate);

        System.out.println(finishedCard);
        }


        public static String formatDate(int month, int day, int year)
        {
        String formatDate = String.format("%02d/%02d/%4d", month, day, year);
        return formatDate;                
        }


        public static String formatCard (String surname, String givenName, String category,
         String cardNum, String birthCountry, String termsAndConditions,
          char sex, String uscisNum, String dateOfBirth, String validDate, String expireDate)
        {
                String fullCard = "";
        
                fullCard += String.format("╔══════════════════════════════════════════════════════════════════════╗%n");
                fullCard += String.format("║%35s%35s║%n", TITLE_USA, "");
                fullCard += String.format("║%60s%10s║%n", TITLE_EAC, "");
                fullCard += String.format("║%-25s%-45s║%n", "", LABEL_SURNAME);
                fullCard += String.format("║%-25s%-45s║%n", "", surname);
                fullCard += String.format("║%-25s%-45s║%n", ASCII_ART_0, LABEL_GIVEN_NAME);
                fullCard += String.format("║%-25s%-45s║%n", ASCII_ART_1, givenName);
                fullCard += String.format("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_2, LABEL_USCIS_NUM, LABEL_CATEGORY, LABEL_CARD_NUM);
                fullCard += String.format("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_3, uscisNum, category, cardNum);
                fullCard += String.format("║%-25s%-45s║%n", ASCII_ART_4, LABEL_BIRTH_COUNTRY);
                fullCard += String.format("║%-25s%-45s║%n", ASCII_ART_5, birthCountry);
                fullCard += String.format("║%-25s%-45s║%n", ASCII_ART_6, LABEL_TERMS_CONDITIONS);
                fullCard += String.format("║%-25s%-45s║%n", ASCII_ART_7, termsAndConditions);
                fullCard += String.format("║%-25s%-15s%-30s║%n", ASCII_ART_8, LABEL_BIRTH_DATE, LABEL_SEX);
                fullCard += String.format("║%-25s%-15s%-30s║%n", ASCII_ART_9, dateOfBirth, sex);
                fullCard += String.format("║%-25s%-15s%-30s║%n", "", LABEL_VALID_DATE, validDate);
                fullCard += String.format("║%-25s%-15s%-30s║%n", "", LABEL_EXPIRE_DATE, expireDate);
                fullCard += String.format("║%-25s%-45s║%n", ASCII_CREDIT, LABEL_REENTRY_DISCLAIMER);
                fullCard += String.format("╚══════════════════════════════════════════════════════════════════════╝");

                return fullCard;
                }

}
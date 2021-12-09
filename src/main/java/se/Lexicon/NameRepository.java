package se.Lexicon;
import  java.util.Arrays;
public class NameRepository {



    private static String[] names = new String[0];

    public static int getSize(){
        return names.length;

    }
    public static void setNames(String [] names){
        NameRepository.names = names;
    }
    public static void clear(){
        names=new String[0];
    }
    public static String [] findAll(){
        return names;
    }

    // Part 2
    public static String find(final String fullName){
        for (String name:   names) {
            if (name.equalsIgnoreCase(fullName))
                return fullName;
        }
        return null;
    }
    public static boolean add(final String fullName){
        if (find(fullName) ==null){
            names =Arrays.copyOf(names,names.length+1);
            names[names.length-1] = fullName;
            return  true;
        }
        else return false;
    }

    // Part 3
    public static String[] findByFirstName(final String firstName){
        String[] matchingNames = new String[0];
        for (String name:   names) {
            if (name.split(" ")[0].equalsIgnoreCase(firstName))
                matchingNames = Arrays.copyOf(names,names.length+1);
            matchingNames[matchingNames.length-1] = name;
        }
        return matchingNames;
    }

    public static String[] findByLastName(final String lastName){
        String[] matchingNames = new String[0];
        for (String name: names) {
            if (name.split(" ")[1].equalsIgnoreCase(lastName))
                matchingNames = Arrays.copyOf(names,names.length+1);
            matchingNames[matchingNames.length-1] = name;
        }
        return matchingNames;
    }

    public static boolean update(final String original, final String updatedName){
        if (original.equalsIgnoreCase(updatedName))
            return false;
        for (String name: names) {
            if (name.equalsIgnoreCase(original)) {
                name = updatedName;
                return true;
            }
        }
        return false;

    }

    // Part 4
    public static boolean remove(final String fullName) {
        if (find(fullName) != null) {
            String[] newArray= new String[names.length-1];
            int j= 0;
            for (int i = 0; i < names.length; i++) {
                if (!names[i].equalsIgnoreCase(fullName)) {
                    newArray[j]=names[i];
                    j++;
                }
            }
            names= Arrays.copyOf(newArray,newArray.length);
            return true;
        } else
            return false;
    }

}
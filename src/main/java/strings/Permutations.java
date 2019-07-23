package strings;

public class Permutations {

    private boolean[] used;
    private StringBuilder out = new StringBuilder();
    private final String in;
    public Permutations( final String str ){
        in = str;
        used = new boolean[ in.length() ];
    }
    public void permute( ){
        if( out.length() == in.length() ){
            System.out.println( out );
            return;
        }
        for( int i = 0; i < in.length(); ++i ){
            if( used[i] ) continue;
            out.append( in.charAt(i) );
            used[i] = true;
            permute();
            used[i] = false;
            out.setLength( out.length() - 1 );
        }
    }

}


//    public static ArrayList<String> getPermutations(String s) {
//        ArrayList<String> permutations = new ArrayList<String>();
//        if (s == null) // error case
//            return null;
//        else if (s.length() == 0) { // base case
//            permutations.add("");
//            return permutations;
//        }
//        char first = s.charAt(0); // get the first character
//        String remainder = s.substring(1); // remove the first character
//        ArrayList<String> words = getPermutations(remainder);
//        for (String word : words) {
//            for (int j = 0; j <= word.length(); j++) {
//                permutations.add(insertCharAt(word, first, j));
//            }
//        }
//        return permutations;
//    }
//    // Helper method
//    public static String insertCharAt(String word, char c, int i) {
//        String start = word.substring(0, i);
//        String end = word.substring(i);
//        return start + c + end;
//    }
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Map each alien character to its position in the alphabet.
        Map<Character, Integer> orderMap = new HashMap<Character, Integer>();
        // Build the alien alphabet lookup table.
        for(int i=0; i<order.length();i++) {
            orderMap.put(order.charAt(i), i);
        }

        // Compare each adjacent pair until the first differing character.
        for(int i=0; i<words.length-1; i++) {
            // Compare characters until their ordering is determined.
            for(int j=0;j<words[i].length();j++) {
                
                if(j > words[i+1].length()-1) {
                    return false;
                }

                if(words[i].charAt(j) != words[i+1].charAt(j)) {
                    int currLetter = orderMap.get(words[i].charAt(j));
                    int nextLetter = orderMap.get(words[i+1].charAt(j));
                    if(nextLetter < currLetter) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }
        return true;
        
    }
}
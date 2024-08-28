import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            
            // Determine how many words can fit into the current line
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            
            StringBuilder line = new StringBuilder();
            int numberOfWordsInLine = last - index;
            int spacesToDistribute = maxWidth - totalChars;
            
            // If it's the last line or only one word fits in the line, left-justify
            if (last == words.length || numberOfWordsInLine == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) line.append(" ");
                }
                int remainingSpaces = maxWidth - line.length();
                while (remainingSpaces-- > 0) line.append(" ");
            } else {
                // Distribute spaces evenly
                int spacesBetweenWords = spacesToDistribute / (numberOfWordsInLine - 1);
                int extraSpaces = spacesToDistribute % (numberOfWordsInLine - 1);
                
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= spacesBetweenWords + (i - index < extraSpaces ? 1 : 0); j++) {
                            line.append(" ");
                        }
                    }
                }
            }
            
            result.add(line.toString());
            index = last;
        }
        
        return result;
    }
}

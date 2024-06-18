public class Main4 {
    public static void main(String[] args) {
        String string1 = "<body><center><h1> The Little Boat </h1></center><p> The storm tossed the little boat like a cheap sneaker in an old washing machine. The three drunken fishermen were used to such treatment, of course, but not the tree salesman, who even as a stowaway now felt that he had overpaid for the voyage. </p><ol><li> Will the salesman die? </li><li> What color is the boat? </li><li> And what about Naomi? </li></ol></body>";
        String string2 = "<body><center><h1> The Little Boat </center><p> The storm tossed the little boat like a cheap sneaker in an old washing machine. The three drunken fishermen were used to such treatment, of course, but not the tree salesman, who even as a stowaway now felt that he had overpaid for the voyage. </p><ol><li> Will the salesman die? </li><li> What color is the boat? </li><li> And what about Naomi? </li></ol></body>";
        String string3 = "<body><center><h1> The Little Boat </h1></center><p> The storm tossed the little boat like a cheap sneaker in an old washing machine. <li> Will the salesman die? </li></ol></body>";

        System.out.println(isMatched2(string1)); // should return true
        System.out.println(isMatched2(string2)); // should return false
        System.out.println(isMatched2(string3)); // should return false 
    }

    public static boolean isMatched2(String string) {
        ArrayStack<String> stack = new ArrayStack<>(string.length());
        int j = 0;
        while (j < string.length()) {
            int open = string.indexOf('<', j);

            if (open == -1){
                break;
            } 

            int close = string.indexOf('>', open);

            if (close == -1){
                break;
            } 

            String tag = string.substring(open + 1, close);

            if (!tag.startsWith("/")) {
                stack.push(tag); // push opening tag onto stack
            } 
            else {
                if (stack.isEmpty()) {
                    return false; // no tag to match
                }
                String top = stack.pop();
                if (!tag.substring(1).equals(top)) {
                    return false; // mismatched tag
                }
            }
            j = close + 1;
        }

        return stack.isEmpty(); // ensure all tags matched
    }
}
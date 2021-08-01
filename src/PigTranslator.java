public class PigTranslator {

    public static String translate(String string) {
        string = string.toLowerCase();
        StringBuilder result;
        String[] splitString = string.split(" ");
        for (int i = 0; i < splitString.length; i++) {

            String word = splitString[i];
            result = new StringBuilder();
            // If word starts with vowel or xr or yt
            if (word.matches("([aeiou]|xr|yt).*")) {
                result.append(word);
                result.append("ay");
                splitString[i] = result.toString();
            }
            // If word starts from consonant
            else {
                // If word starts from consonant and contains "y"
                if(word.contains("y"))
                {
                    int yIndex= word.indexOf("y");
                    result.append(word.substring(yIndex));
                    result.append(word.substring(0,yIndex));
                    result.append("ay");
                    splitString[i] = result.toString();

                }
                // If word starts from consonant and does not contain "y"
                else {
                    for (int k = 0; k < word.length(); k++) {
                        int q = 0;

                        if ("aeiou".contains("" + word.charAt(k))) {
                            // If word contains "qu"
                            if (word.contains("qu")) {
                                q = 1;
                            }

                            result.append(word.substring(k + q));
                            result.append(word.substring(0, k + q));
                            result.append("ay");
                            splitString[i] = result.toString();
                            break;
                        }
                    }
                }

            }



            }


            return String.join(" ", splitString);
        }

        public static void main (String args[])
        {
            System.out.println(translate("yttria xray chair square my rhythm apple ear equal pig koala xenon qat queen thrush quick fast run"));

        }
    }


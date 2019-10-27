package telephony;

import java.util.List;

public class Smartphone implements Callable,Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder(this.urls.size());
        String formater = "Browsing: %s!";
        for (String url : this.urls) {
            if (url.matches(".*\\d.*")){
                sb.append("Invalid URL!");
            }else {
                sb.append(String.format(formater,url));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder(this.numbers.size());
        String formater = "Calling... %s";
        for (String number : this.numbers) {
            if (number.equals(number.replaceAll("[^0-9]",""))){
                sb.append(String.format(formater,number));

            }else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}

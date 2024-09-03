import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------1-----------------");
        List<Integer> numbers = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            numbers.add(random.nextInt(10, 1000));
        }

        List<Integer> newNumbers = numbers.stream().filter(n -> n > 500).toList();

        System.out.println(numbers);
        System.out.println(newNumbers);




        System.out.println("-----------------2-----------------");
        System.out.println("Число нечетных чисел: " + numbers.stream().filter(n -> n % 2 == 1).count());




        System.out.println("-----------------3-----------------");
        List<String> strs = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            strs.add(generateRandomString(random.nextInt(5, 11)));
        }

        List<String> strsPalindrome = strs.stream().map(n -> toPalindrome(n)).toList();

        System.out.println(strs);
        System.out.println(strsPalindrome);




        System.out.println("-----------------4-----------------");
        List<Client> clients = new ArrayList<>();

        List<Integer> uniqueNums = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            uniqueNums.add(i);
        }


        for (int i = 0; i < 10; i++) {
            int uniqueNum = random.nextInt(100, 1000);
            int phoneType = random.nextInt(0, 2);
            while (uniqueNum > uniqueNums.size()) {
                uniqueNum = random.nextInt(1, 10);
            }

            clients.add(new Client(uniqueNums.get(uniqueNum),
                    generateRandomString(random.nextInt(4, 9)),
                    random.nextInt(18, 80),
                    List.of(new Phone(generateRandomNumbers(),
                                    phoneType == 0 ? PhoneType.MOBILE : PhoneType.STATIONARY),
                            new Phone(generateRandomNumbers(),
                                    phoneType == 0 ? PhoneType.MOBILE : PhoneType.STATIONARY))));

            uniqueNums.remove(uniqueNum);
        }


        clients.forEach(n -> System.out.println(n.toString()));

        Client resultClient = clients.stream().filter(client -> client.getPhones().stream().anyMatch(phone -> phone.getPhoneType() == PhoneType.STATIONARY)).
                reduce((client1, client2) -> client1.getAge() > client2.getAge() ? client1 : client2).orElse(null);

        System.out.println("Результат");
        System.out.println(resultClient.toString());

    }

    public static String toPalindrome(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return str + stringBuilder.reverse();
    }


    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int bool = random.nextInt(0, 2);
            char symbol = (char) (bool == 0 ? random.nextInt(65, 91) : random.nextInt(97,123));

            sb.append(symbol);
        }

        return sb.toString();
    }

    public static String generateRandomNumbers() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder("+99670");

        for (int i = 0; i < 6; i++) {
            stringBuilder.append((char) (random.nextInt(48, 58)));
        }

        return stringBuilder.toString();
    }

}

public class Program {

    public static void main(String[] args) {
        // Testaa sanakirjaa täällä
//        DictionaryOfManyTranslations dictionary = new DictionaryOfManyTranslations();
//        dictionary.add("lie", "maata");
//        dictionary.add("lie", "valehdella");
//
//        dictionary.add("bow", "jousi");
//        dictionary.add("bow", "kumartaa");
//
//        System.out.println(dictionary.translate("lie"));
//        dictionary.remove("bow");
//        System.out.println(dictionary.translate("bow"));

        DictionaryOfManyTranslations dic = new DictionaryOfManyTranslations();

        dic.add("Kaladin", "Sad");
        dic.add("Kaladin", "Bridge Boy");
        dic.add("Dalinar", "Grumpy");
        dic.add("Dalinar", "Burned sh-sh-sh");

        System.out.println(dic.translate("Dalinar"));
    }
}

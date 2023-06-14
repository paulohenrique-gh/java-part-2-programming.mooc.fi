
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int num = 1;
        int i = 0;
        int j = square.getWidth() / 2;

        while (num <= size * size) {
            if (i > square.getWidth() - 1) {
                i = 1;
            }
            if (j < 0) {
                j = square.getWidth() - 1;
            }

            if (square.readValue(j, i) == 0) {
                square.placeValue(j, i, num);
            } else {
                i += 2;
                j -= 1;
                continue;
            }

            i -= 1;
            if (i < 0) {
                i = square.getWidth() - 1;
            }
            j += 1;
            if (j > square.getWidth() - 1) {
                j = 0;
            }

            num++;
        }

        return square;
    }

}

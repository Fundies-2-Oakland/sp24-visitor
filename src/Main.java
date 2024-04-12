import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<DocumentPart> elements = List.of(
                new Header(1, "Ellen's Favorite Quotations"),
                new Paragraph("Ellen often repeats these sayings to her students:"),
                new BulletList(List.of(
                        "There are only two hard things in computer science: " +
                                "cache invalidation, naming, and off-by-one errors. --Jeff Atwood",
                        "AI is whatever hasn't been done yet. --Larry Tesler",
                        "I'm not a great programmer. I'm just a good programmer with great habits. --Kent Beck"
                )));
        renderDoc(new HtmlGeneratingVisitor(), elements);
        renderDoc(new MarkdownGeneratingVisitor(), elements);
        renderDoc(new CharacterCountingVisitor(), elements);
    }

    public RowColPair chooseNextMove(GameModel model, int depth, TileColor tileColor) {
        // The initial value of alpha is -Double.MAX_VALUE because
        // Double.MIN_VALUE is the smallest *positive* double value.
        Move move = getMyMove(model, depth, -Double.MAX_VALUE, Double.MAX_VALUE, tileColor);
        return move.getPosition();
    }

    @Override
    public Move getMyMove(GameModel model, int depth, TileColor tileColor) {
        return getMyMove(model, depth, -Double.MAX_VALUE, Double.MAX_VALUE, tileColor);
    }

    private static void renderDoc(DocumentVisitor visitor, List<DocumentPart> parts) {
        for (DocumentPart part : parts) {
            part.accept(visitor);
        }
        System.out.println(visitor.getOutput());
    }
}

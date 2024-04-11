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
        visitAllDocumentParts(new HtmlGeneratingVisitor(), elements);
        visitAllDocumentParts(new MarkdownGeneratingVisitor(), elements);
        visitAllDocumentParts(new CharacterCountingVisitor(), elements);
   }

    private static void visitAllDocumentParts(DocumentVisitor visitor, List<DocumentPart> parts) {
        for (DocumentPart part : parts) {
            part.accept(visitor);
        }
        System.out.println(visitor.getOutput());
    }
}

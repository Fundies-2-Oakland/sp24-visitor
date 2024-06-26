public class Paragraph implements DocumentPart {
    final String text;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visitParagraph(this);
    }
}

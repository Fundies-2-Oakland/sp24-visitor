public class Header implements DocumentPart {
    int level;
    String text;

    public Header(int level, String text) {
        this.level = level;
        this.text = text;
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visitHeader(this);
    }
}

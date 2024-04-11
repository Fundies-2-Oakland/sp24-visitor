public class CharacterCountingVisitor implements DocumentVisitor {
    int numChars = 0;

    @Override
    public void visitHeader(Header header) {
        numChars += header.text.length();
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        numChars += paragraph.text.length();
    }

    @Override
    public void visitBulletList(BulletList bulletList) {
        for (String item : bulletList.items) {
            numChars += item.length();
        }
    }

    @Override
    public String getOutput() {
        return "Number of characters: " + numChars;
    }
}

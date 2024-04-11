public class CharacterCountingVisitor implements DocumentVisitor {
    int numCharacters = 0;

    @Override
    public void visitHeader(Header header) {
        numCharacters += header.text.length();
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        numCharacters += paragraph.text.length();
    }

    @Override
    public void visitBulletList(BulletList bulletList) {
        for (String item : bulletList.items) {
            numCharacters += item.length();
        }
    }

    @Override
    public String getOutput() {
        return "The number of characters in the document is " + numCharacters + "\n";
    }
}

public class CharacterCountingVisitor implements DocumentVisitor {
    private int count = 0;

    @Override
    public void visitHeader(Header header) {
        count += header.text.length();
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        count += paragraph.text.length();
    }

    @Override
    public void visitBulletList(BulletList bulletList) {
        for (String item : bulletList.items) {
            count += item.length();
        }
    }

    @Override
    public String getOutput() {
        return "The character count is " + count + ".";
    }
}

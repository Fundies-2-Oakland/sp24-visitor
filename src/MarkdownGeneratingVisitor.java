public class MarkdownGeneratingVisitor implements DocumentVisitor {
    StringBuilder sb = new StringBuilder();

    @Override
    public void visitHeader(Header header) {
        sb.append("#".repeat(header.level));
        sb.append(' ').append(header.text).append('\n');
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        sb.append(paragraph.text);
    }

    @Override
    public void visitBulletList(BulletList bulletList) {
        sb.append('\n');
        for (String item : bulletList.items) {
            sb.append("* ").append(item).append('\n');
        }
        sb.append('\n');
    }

    @Override
    public String getOutput() {
        return sb.toString();
    }
}

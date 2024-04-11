public class MarkdownGeneratingVisitor implements DocumentVisitor {
    StringBuilder sb = new StringBuilder();

    @Override
    public void visitHeader(Header header) {
        // # Title
        sb.append("#".repeat(header.level));
        sb.append(' ');
        sb.append(header.text);
        sb.append('\n');
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        sb.append(paragraph.text).append('\n');
    }

    @Override
    public void visitBulletList(BulletList bulletList) {
        for (String item : bulletList.items) {
            sb.append("* ").append(item).append('\n');
        }
    }

    @Override
    public String getOutput() {
        return sb.toString();
    }
}

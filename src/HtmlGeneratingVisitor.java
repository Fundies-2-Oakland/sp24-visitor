public class HtmlGeneratingVisitor implements DocumentVisitor{
    StringBuilder sb = new StringBuilder();

    @Override
    public void visitHeader(Header header) {
        // Example: <h1>Title</h1>
        sb.append(String.format("<h%d>%s</h%d>\n", header.level, header.text, header.level));
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        sb.append("<p>");
        sb.append(paragraph.text);
        sb.append("</p>");
        sb.append("\n");
    }

    @Override
    public void visitBulletList(BulletList bulletList) {
        sb.append("<ul>\n");
        for (String item : bulletList.items) {
            sb.append("<li>").append(item).append("</li>\n");
        }
        sb.append("</ul>\n");
    }

    @Override
    public String getOutput() {
        return sb.toString();
    }
}

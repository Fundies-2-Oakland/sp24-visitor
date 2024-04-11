public class HtmlGeneratingVisitor implements DocumentVisitor {
    @Override
    public void visitHeader(Header header) {
        // Example: <h1>Title</h1>
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {

    }

    @Override
    public void visitBulletList(BulletList bulletList) {

    }

    @Override
    public String getOutput() {
        return null;
    }
}

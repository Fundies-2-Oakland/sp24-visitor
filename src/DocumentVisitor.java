public interface DocumentVisitor {
    void visitHeader(Header header);
    void visitParagraph(Paragraph paragraph);
    void visitBulletList(BulletList bulletList);
    String getOutput();
}

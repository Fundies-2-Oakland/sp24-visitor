import java.util.List;

public class BulletList implements DocumentElement {
    List<String> items;

    public BulletList(List<String> items) {
        this.items = items;
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visitBulletList(this);
    }
}

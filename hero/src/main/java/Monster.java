import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element {
    public Monster(int x, int y) {
        super(x, y);
    }
    public void draw(TextGraphics graphics) {
        Position position = getPosition();
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }
}

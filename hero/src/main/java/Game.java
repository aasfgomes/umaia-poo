import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;

    public Game(int i, int i1) {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            arena = new Arena(80, 20);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    private void processKey(KeyStroke key) {
        System.out.println(key);
    }

    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if(arena.processKey(key)){
                screen.close();
                break;
            }
        }
    }
}